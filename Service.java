book -id,title,author
getters setters ();
------------
private final List<Book>books=new ArrayList<>();
private int counter=1;

//add
public Book add(Book book){
book.setid(counter++)
books.push(book)
return book;
}

//Read all

public List<Book> getALl(){
return books;
}
//getByid

public Optional<Book>getById(int id){
return books.stream().filter(b->b.getId()==id).findFirst();
}
//update

public Optional<Book>update(int id,Book update){
return getByid(id).map(b->{
b.setTitle(update.getTitle)
b.setAUthor(upate.GetAUthor)
})
}

//delete
public Boolean delete(int id){
return books.removeIf(b->b.getId()===id);
}
----------------------------------------------------------------------------
  






