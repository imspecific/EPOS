<!DOCTYPE html>
<html>
   <head>
      <title>Login Page</title>
      <style>
         * {
            box-sizing: border-box;
         }

         body {
            font-family: Arial, Helvetica, sans-serif;
         }
         .login{
           text-align: center;
         }
         .login h1{
          padding-left: 8px;
         }

         /* On mouse-over */
         .sidenav a:hover,
         .dropdown-btn:hover {
            color: #f1f1f1;
         }

         /* Main content */
         .main {
            margin-left: 200px;
            /* Same as the width of the sidenav */
            font-size: 20px;
            /* Increased text to enable scrolling */
            padding: 0px 10px;
         }

         /* Add an active class to the active dropdown button */
         .active {
            background-color: green;
            color: white;
         }

         /* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
         .dropdown-container {
            display: none;
            background-color: #262626;
            padding-left: 8px;
         }

         /* Optional: Style the caret down icon */
         .fa-caret-down {
            float: right;
            padding-right: 8px;
         }


         /* Style the content */
         .content {
            margin-left: 100px;
            padding-left: 500px;
            margin-top: 150px;
         }

         /* Header Content*/
         .header {
            overflow: hidden;
            background-color: #f1f1f1;
            padding: 20px 10px;
         }

         .header a {
            float: left;
            color: black;
            text-align: center;
            padding: 12px;
            text-decoration: none;
            font-size: 18px;
            line-height: 25px;
            border-radius: 4px;
         }

         .content a {
            float: left;
            color: black;
            text-align: center;
            padding: 12px;
            text-decoration: none;
            font-size: 18px;
            line-height: 25px;
            border-radius: 4px;
         }

         .header a.logo {
            font-size: 40px;
            font-weight: bold;
         }

         .header a:hover {
            background-color: #ddd;
            color: black;
         }

         .header a.active {
            background-color: dodgerblue;
            color: white;
         }

         .header-right {
            float: right;
         }
      </style>
   </head>
   <body>
      <div class="header">
         <a href="#" class="logo">EPOS</a>
      </div>
      			
      <form  action="login" method="post">
         <div class="login"> 
	       <h1>EPOS</h1>
           <h4>The Online Point of Sale Solution</h4>
            <label for="username">
               <b>Username:</b>
            </label>
            <input type="text" placeholder="Enter Username" name="userName" required>
            <br />
            <%
            	String userName = request.getParameter("userName");
            	session.setAttribute("userName", userName);
            %>
            <br />
            <label for="password">
               <b>Password: </b>
            </label>
            <input type="password" placeholder="Enter Password" name="password" required><br /><br />
            <label for="domain">
               <b> Domain: </b>
            </label>            
            <input type="radio" id="admin" name="loginUser" value="Admin" required="required" >
			<label for="admin">Admin</label>
			<input type="radio" id="eposadmin" name="loginUser" value="EPOS Admin" required="required" >
			<label for="eposadmin">EPOS Admin</label><br>
            <br />
            <br />
            <button type="submit" class="btn">Login</button>
         </div>
      </form>
   </body>
</html>