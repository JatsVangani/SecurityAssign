# SecurityAssign

1.Cross Site Scripting:
simple POST method in our sample application to create and save a Patient to the database.

      @PostMapping("/createPatient")
     public void createPatient(@RequestBody Patient patient) throws SQLException {
        if(patient!=null) {
       ps.createPatient(patient);
     }
 }
Since the field ‘doctorName’ is a free form field in the Book object, a user could enter any value and the method simply saves it. An attacker could insert javascript code into this field. Our UI can potentially execute this javascript while rendering the patient, leading to 

      XSS.POST /patient{
     "name" : "Harry Potter",
     "age" : 22
     "doctorName" : "<script>alert(document.cookie)</script>"
    }


2.SQLInjection
Injection attacks work because, for many applications, the only way to execute a given computation is to dynamically generate code that is in turn run by another system or component. 
                
		public Patient getDetailsbyId(int id) throws SQLException {
		String sqlQuery = "select * from patient_jdbl61 where id = "+id;
		
		logger.info("INSIDE PATIENT BY ID METHOD");
		Statement stm= con.createStatement();
		ResultSet rs=stm.executeQuery(sqlQuery);


3. CSRF Attack
   Assume that your Hospital’s website provides a form that allows transferring patient record from the currently logged in user to another account. For example, the transfer form might look like:
Transfer form
<form method="post"
	action="/transfer">
<input type="text"
	name="amount"/>
<input type="text"
	name="routingNumber"/>
<input type="text"
	name="account"/>
<input type="submit"
	value="Transfer"/>
</form>

Now pretend you authenticate to your Hospital’s website and then, without logging out, visit an evil website. The evil website contains an HTML page with the malicious Form
you click on the submit button. In the process, you have unintentionally transferred patient records to a malicious user.
  
