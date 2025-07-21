@RestController
@RequestMapping("/Book")

========================================================

//create --postmap

public RE<Book> create(@RequestBody Book book){
Book saved=service.add(book)
return RE.status(HttpStatus.CREATED).body(saved)

}
--------

//ReadAll --getmap

public RE<List<Book> GetALL(){
list<Book>list=service.getAll();
return list.isEmpty()?
		RE.noContent().build():
		RE.ok(list
}

========================================================

//ReadByID --getmap("/{id}")
public RE <Book> GetByID(@PathVariable int id){
return service.getByid(id)
              .map(RE::ok)
	      .orElse(RE.notFound().build());

}

========================================================
//Update   --putmap("/{id}")
public RE<String>Update(@RequestBody Book book,PathVariable int id){
return service.update(id,updated).isPresent()?
  RE.ok(""):RE.status(HttpStatus.NoTFOUN).body("")

}
---------

//Delete  --deletemap("/{id}")
public ResponseEntity<String>Delete(@pathvariable int id){
return service.delete(id)
   ?RE.ok(""):RE.status(httpStatus.NOTFOUND).body("")

}
==========================================================

-----------------------------------------------------------------------------------------------------------------------------------------------

  
