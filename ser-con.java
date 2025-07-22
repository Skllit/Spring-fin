-------------------------------------------------------------------------------
package com.example.two.Service;

import com.example.two.Models.Booking;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingService {

    private static int counter=0;
    private List<Booking>bookings=new ArrayList<>();


    //create

    public Booking Addbooking(Booking book){
        book.setId(counter++);
        bookings.add(book);
        return book;
    }

    //getAll
    public List<Booking> GetAll(){
        return  bookings;
    }


    //getbyid
    public Optional<Booking> GetById(int id){
        return bookings.stream().filter(b->b.getId()==id).findFirst();
    }

    //update
    public  boolean Update(int id,Booking book){
        return GetById(id).map(b->{
            b.setName(book.getName());
            b.setRoomno(book.getRoomno());
            return true;
        }).orElse(false);
    }
    //delete
    public boolean Delete(int id){
        return bookings.removeIf(s->s.getId()==id);
    }




}
 -----------------------------------------------------------------------------
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bs;

    @PostMapping
    public ResponseEntity<Booking>ADD(@RequestBody Booking book){
        Booking saved=bs.Addbooking(book);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>>GETALl(){
        List<Booking>list=bs.GetAll();
        if(list.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Booking>GETBYID(@PathVariable int id){
        return bs.GetById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    @PutMapping
    public ResponseEntity<String>UPDATE(@RequestBody Booking book,@PathVariable int id){
        boolean updated=bs.Update(id,book);
        if(updated){
            return new ResponseEntity<>("",HttpStatus.OK);

        }else{
            return  new ResponseEntity<>("",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String>DELETE(@PathVariable int id){
        boolean deleted=bs.Delete(id);
        if(deleted){
            return  new ResponseEntity<>("",HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }










}
