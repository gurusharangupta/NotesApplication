1. Please create gotprint schema in your mysql db
2. Update username and password in applicationcontex.xml of your mysql db
3. Please insert entries into your user table

	eg. insert into USER_DETAILS VALUES('guru@gmail.com',now(),'guru',now());

sample code for INSERT into notes

	eg.  
	
	{
  		 "id":2,
 		 "title": "got print application",
  		 "note": "Create a new note"
 
	}
	
	sample code for DELETE of note (id needs to be provided for notes to be deleted, since title and note are note unique)
	
	{
  		 "id":2,
 		
 
	}
	
	sample code for UPDATE(id should be present in database for notes to be updated)
	
	{
  		 "id":2,
 		 "title": "got print application",
  		 "note": "Note updated"
 
	}
	
	
	