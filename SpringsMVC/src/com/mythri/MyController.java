package com.mythri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mnp.dto.Address;
import com.mnp.dto.Employee;

/**
 * @author APSTEP
 *
 */
@Controller
public class MyController {
	
	@Autowired
	RegisterService service;

	/*@RequestMapping(value="/hello" , method= RequestMethod.GET )
	public String showPage(){
		return "welcome";
	}*/
	
	//or
	/**
			1.client clicks of a link and make a backend call.
			link : /hello
	 * @return
	 */
	@RequestMapping(value="/hello" , method= RequestMethod.GET )
	public ModelAndView showPage1(){
		return new ModelAndView("welcome");//here welcome.jsp is the response page
	}
	

	/**
	 * @return
	 * 
	 * addObject take two paarams :
1st param : string
2nd param : can be any data type 
	 */
	@RequestMapping(value = "/helloWithData", method = RequestMethod.GET) // resouce url = helloWithData , method = GET
	public ModelAndView getHello() {
		ModelAndView response = new ModelAndView("response"); // here response.jsp is the resoonse page name
		response.addObject("message", "hi from backend.. .."); // response data sent to the response.jsp page.
		return response;
	}
	

	@RequestMapping(value = "/helloWithMultiData1",method = RequestMethod.GET)
	public ModelAndView getMultiData() {
		ModelAndView responseObj = new ModelAndView("response");
		responseObj.addObject("age", 34);
		responseObj.addObject("name", "ramesh");
		responseObj.addObject("id", 3000);
		responseObj.addObject("sal", 1133.1331f);
		return responseObj;
	}
	
	@RequestMapping(value = "/helloWithMultiData2",method = RequestMethod.GET)
	public ModelAndView getHelloWithMap() {
		//create map
    Map<String, Object> map = new HashMap<String, Object>();
    
    //add response data to map
		map.put("age", 34);
		map.put("name", "ramesh");
		map.put("id", 3000);
		map.put("sal", 1133.1331f);
    
    //add map to the response obj
		return new ModelAndView("response1", map); // response1.jsp and ,map contains response data
	}
	
	@RequestMapping(value = "/helloWithMultiData3",method = RequestMethod.GET)
	public ModelAndView postHelloWithModelMap(ModelMap map) {
		map.put("message", "message from helloWithMultiData3");
		map.put("result", "Successfully retried multiple data3");
		return new ModelAndView("response", map);
	}
	
	 @RequestMapping(value = "/helloWithObject", method = RequestMethod.GET)
		public ModelAndView sendObj() {
			ModelAndView modelAndView = new ModelAndView("empResponse"); // here empResponse.jsp is the response page
			Employee employee = new Employee(23, 12121, "user1", "shyam", 13131313);
			modelAndView.addObject("message", "process successful...");
			modelAndView.addObject("emp", employee); // we are sending employee obj + string to the response page.
			return modelAndView;
		}
	
	@RequestMapping(value = "/empWithAddress", method = RequestMethod.GET)
	public ModelAndView empWithAddress() {
		ModelAndView modelAndView = new ModelAndView("empResponse1");
		Employee e1 = new Employee(1200, "user1");
		Address address = new Address("hno", "560037", "hyd", "AP", "IN");
		e1.setAddress(address);
		modelAndView.addObject("message", "message from helloWithMultiData");
		modelAndView.addObject("emp", e1);
		return modelAndView;
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ModelAndView check() {
		ModelAndView modelAndView = new ModelAndView("checkResponse");
		modelAndView.addObject("age", 15);
		modelAndView.addObject("name", "");
		return modelAndView;
	}
	
	@RequestMapping(value = "/strList", method = RequestMethod.GET)
	public ModelAndView sendStrrList() {
		ModelAndView modelAndView = new ModelAndView("empsResponse");
		List<String> names= Arrays.asList("hyd","bang","chennai","mumbai","bangalore");
		modelAndView.addObject("names", names);
		return modelAndView;
	}
	
	@RequestMapping(value = "/empList", method = RequestMethod.GET)
	public ModelAndView sendList() {
		ModelAndView response = new ModelAndView("empsResponse");
		
		List<Employee> emps = new ArrayList<>();
		for(int i=0;i<10;i++){
			Employee employee = new Employee(30+i, 5000+i, "user"+i, "kumar"+i, 10000+i);
			emps.add(employee);
		}
		     
		response.addObject("emps", emps);
		return response;
	}
/*
  Request Page should take input for
  ->name
  ->age
  ->sal
  
 1. Customer will click on  "register Emp"
 2. A form will be displayed with name + age+ sal
 3. Customer will fill the data in the form and clicks on submit button
 4. In the resonse page show the data submitted by customer.
  
 
-> every Field in the request page  should have a name.
  For capturing the input from the web page , we need to write new annotation
   @RequestParam("uName") String userName,
  @RequestParam("age") int age,
  @RequestParam("sal") float mysal,

the Field name in the jsp should be used for the  @RequestParam annotation.
  
   // every input from the web page is the input argument to the controller method.
	
when we click on submit buton:
Resource url : /register
HTTP Mrethod : GET
 * */
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerGet(
			@RequestParam("uName") String userName,
			@RequestParam("age") int age, 
			@RequestParam("sal") float sal) {
		// the Field name in the jsp SHOULD be used for the  @RequestParam annotation.
		// every input from the web page is the input argument to the controller method.
		String resData = "Request Data : name= " + userName + " , age = " + age + ", sal =" + sal;
		return new ModelAndView("readDetails", "myData", resData);   //readDetails.jsp is the response page and resData is the response data to the jsp
	}

/*
For a GET Call, the data submitted by the customer is appended to the url and is visible in the URL.
input data is part of request URL.
  
EX: 
http:/localhost:7189/SpringsMVC2/register?uName=Ramesh&age=25&sal=48000&submit=submit
Base_url + resource_url + Query params [ after ? what ever that comes ]
Query Param  Names are : uName , age and sal
Every query param is seperated by  & 
For generic data submission use GET call.
CANNOT USE FOR SENSITIVE DATA SUBMISISON.
Cannot handle large data. 


For a  post call, the data submitted by customer is not appended to URL , 
input data is part of request body.
EX: http:/localhost:7189/SpringsMVC2/register
For secure data transfer use POST call. 
Can handle large data.
File uploads/image  upoad should be done using post calls.
*/            
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPost(
			@RequestParam("uName") String userName,
			@RequestParam("age") int age, 
			@RequestParam("sal") float sal) {
		String resData = "Hi " + userName + " , age = " + age + ", sal =" + sal;
		return new ModelAndView("readDetails", "myData", resData);
	}
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 * 
	 1.Request page has username and password , submit button
		2. customer will enter the usernam and password and clcks on submit button.
		3.  - if username value ="admin" and password ="admin" then show "Login success"
      else show "Login failure"
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		String resData = "";
		if (userName.equals("admin")  && password.equals("admin")) {
			resData = "Login is Succes";
		} else {
			resData = "Login Failure due to invalid creds";
		}
		ModelAndView res =  new ModelAndView("response");
		res.addObject("message", resData);
		return res;
	}
	
	//path param
	@RequestMapping("/getEmp/{id}/{name}")
	public ModelAndView getEmployeeByPathId(
			@PathVariable("id") int userId, 
			@PathVariable("name") String name)
			throws Exception {
		String myData = "userId = "+userId +"name="+name;
		return new ModelAndView("readDetails", "myData", myData);
	}
	
	/*
	 * Employee emp = null;//empDao.getEmpById(userId); if(emp==null) throw
	 * new EmployeeNotFoundException("Invalid emp id",userId);
	 */
	
	@RequestMapping("/helloEx")
	public ModelAndView getData2(HttpServletRequest request,HttpServletResponse res) {
		String data = "Hi How are you!!";
		return new ModelAndView("response", "message", data);
	}

	/*
	 -> A form that has username and password + submit
	 -> if the username value is "admin" and passwrd value is "admin" , then show sucess.jsp with msg as "login success"
  else show failure.jsp with msg as login failure ""
	 */
	@RequestMapping("/getUserDetails")
	public ModelAndView helloWorld(HttpServletRequest request,
			HttpServletResponse res) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if ("admin".equals(name) && "admin".equals(password)) {
			String message = "HELLO " + name;
			return new ModelAndView("hellopage", "userName", name);
		} else {
			return new ModelAndView("errorpage", "message",
					"Sorry, username or password error");
		}
	}

	 @RequestMapping(value = "/registerform", method = RequestMethod.GET)	
	 public ModelAndView showRegister() {
		 return new ModelAndView("register");
	 }
		 
	/*
	register.jsp
	-------------
	A Form to contain  -> Id , firstName , lastName , password , age as inputs + Register button
	
	Controller method backend:
	----------------------------------------------------------------------
	-> Validation 
	- ID should start with C_ OR P_     [Invalid Id]
	- firstName should be min 10 chars
	- last name should be min 8 chars
	- password should be betwen 10 to 15 , spaces are not allowed  , 
	- age should be between 18 & 60
	
	If validation is success then do the registration and show response using show success.jsp  -> Registration succes
	If validation is failed then show register.jsp -> Registration failure message + what exactly is wrong + Retain the input data
	
	//when input data is invalid then
	//carry the error message and the object to the response page
		message -> to disply so that customer can underatand the error
		object  -> to retain the data.
	* */
	 


@RequestMapping(value = "/registerform", method = RequestMethod.POST)
	public ModelAndView registerValidation(@RequestParam("ID") String id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("age") int age,
			@RequestParam("password") String password) {
    
    //keep request data inside the object
		RegisterForm registerObj = new RegisterForm();
		registerObj.setAge(age);
		registerObj.setId(id);
		registerObj.setFirstName(firstName);
		registerObj.setLastName(lastName);
		registerObj.setPassword(password);

    //if id is invalid then return  message and object
		if (!(id.startsWith("C_") || id.startsWith("P_"))) {
			ModelAndView response = new ModelAndView("register");
			response.addObject("msg", "id should start with C_ or P_");
			response.addObject("form", registerObj);
			return response;
		}
    
    //if firstName is invalid then return  message and object
		if ((firstName.length() < 10)) {
			ModelAndView response = new ModelAndView("register");
			response.addObject("msg", "firstName should be min 10 characters");
			response.addObject("form", registerObj);

			return response;
		}
  
  //if lastName is invalid then return  message and object
		if ((lastName.length() < 8)) {
			ModelAndView response = new ModelAndView("register");
			response.addObject("msg", "lastName should be min 8 characters");
			response.addObject("form", registerObj);

			return response;
		}

  //if password is invalid then return message and object
		if (password.length() < 10 || password.contains(" ") || password.length() > 15) {
			ModelAndView response = new ModelAndView("register");
			response.addObject("msg", "password should be min 10, max 15 characters and space not allowed");
			response.addObject("form", registerObj);

			return response;
		}
  
    //if age is invalid then return  message and object
		if (age < 18 || age > 60) {
			ModelAndView response = new ModelAndView("register");
			response.addObject("msg", "age should be min 18, max 60");
			response.addObject("form", registerObj);

			return response;
		}

  //if all input data si valid then return the success msg to the success page
		ModelAndView response = new ModelAndView("successRegister");
		response.addObject("msg", "registration success");
		return response;

	}
	  // send multi errors on above prog.
	  //try to move the validation logic to service class.
	  
	  //show all error msgs


@RequestMapping(value = "/registerform1", method = RequestMethod.POST)
	public ModelAndView registerValidation1(@RequestParam("ID") String id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("age") int age,
			@RequestParam("password") String password) {
    //keep the request data inside fthe obj
		RegisterForm registerObj = new RegisterForm();
		registerObj.setAge(age);
		registerObj.setId(id);
		registerObj.setFirstName(firstName);
		registerObj.setLastName(lastName);
		registerObj.setPassword(password);

    //get the list of error message
		List<String> list = validate(registerObj);

		if (list.isEmpty()) {
      //no errror found
			ModelAndView response = new ModelAndView("successRegister");
			response.addObject("msg", "registration success");
			return response;
		} else {
      //send error mss + obj to the response page
			ModelAndView response = new ModelAndView("register");
			response.addObject("form1", registerObj);
			response.addObject("msgs", list);
			return response;
		}
	}

	private List<String> validate(RegisterForm registerObj) {
		List<String> list = new ArrayList<String>();

		if (!(registerObj.getId().startsWith("C_") || registerObj.getId().startsWith("P_"))) {
			list.add("id should start with C_ or P_");

		}
		if ((registerObj.getFirstName().length() < 10)) {
			list.add("fistname should contain min 10 characters");

		}
		if ((registerObj.getLastName().length() < 8)) {
			list.add("fistname should contain min 8 characters");
		}

		if (registerObj.getPassword().length() < 10 || registerObj.getPassword().contains(" ")
				|| registerObj.getPassword().length() > 15) {
			list.add("password should be min 10, max 15 characters and space not allowed");
		}
		if (registerObj.getAge() < 18 || registerObj.getAge() > 60) {
			list.add("age should be min 18, max 60");
		}
		return list;
	}
	  
	/**
	 * @param session
	 * @return
	 * session tracking:

		Session: 
		Http is a stateless protocaol.
		server will not recognize the client.
		Every request is New.
		
		Web apps: 
		1.we will authnticate one time using login page
		2.after that cutomer clicks on every link [ he will not provide any auth ]
		
		client identification
		-> sessions
		
		Session obj is created seperately for every customer.
		Session should contain the customer basic info
		session data is availanble for a long time,.
		Session obj coantains the cutsomer info.
		
		-> how to add session data
		[if the data is added to the session , then the data is available to all the pages .
		ex: 
		 if we add a data to session obj during the login page, then the data is available to all the pages.
		 until logout or until session is invalidated.
		]
		-> how to read the session data
		-> how to delete the sesion data
	 */
	@RequestMapping("/homePage")
	public ModelAndView homePage(HttpSession session) {
		String message = "HELLO ";
		return new ModelAndView("hellopage", "sessionData", message);
	}
	
	@RequestMapping(value = "/postSessionData", method = RequestMethod.POST)
	public ModelAndView postSessionData(@RequestParam("uName") String userName, HttpSession session) {// get session obj
		session.setAttribute("myName", userName);// myName is the sesison name
		return new ModelAndView("hellopage", "userName", userName);
	}
	//

	@RequestMapping("/getSessionData")
	public ModelAndView getSessionData(HttpSession session) { // get session obj
		String userName = (String) session.getAttribute("myName"); // get the data inside the session
		if (userName == null || userName.isEmpty()) {
			userName = "[ NO DATA IN SESSION... ]";
		}
		return new ModelAndView("hellopage", "userName", userName);
	}

	@RequestMapping("/deleteSessionData")
	public ModelAndView deleteSessionData(HttpSession session) {
		session.removeAttribute("myName");// delete the data from session
		return new ModelAndView("hellopage", "userName", "NO DATA IN SESSION");
	}
}
