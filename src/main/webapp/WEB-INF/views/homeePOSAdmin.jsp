<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <title>EPOS Admin Home</title>
      <style>
         * {
            box-sizing: border-box;
         }

         body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
         }

         /* Fixed sidenav, full height */
         .sidenav {
            height: 90%;
            width: 150px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 20px;
            margin-top: 90px;
         }

         /* Style the sidenav links and the dropdown button */
         .sidenav a,
         .dropdown-btn {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 15px;
            color: #818181;
            display: block;
            border: none;
            background: none;
            width: 100%;
            text-align: left;
            cursor: pointer;
            outline: none;
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

         /* Some media queries for responsiveness */
         @media screen and (max-height: 450px) {
            .sidenav {
               padding-top: 15px;
            }
         }

         /* Style the content */
         .content {
            margin-left: 100px;
            padding-left: 200px;
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
      <div class="sidenav">
         <a href="/homeePOSAdmin"> Home </a>
         
         <button class="dropdown-btn"> EPOS Product <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="/addcategory"> Add Category </a>
            <a href="/addproduct"> Add New Product </a>
            <a href="/updateproduct"> Update Product </a>
       	</div>
         
         <button class="dropdown-btn"> Store <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="/addstore"> Add New Store </a>
            <a href="/updatestore"> Update Store </a>
            <a href="/viewstore"> View Store </a>
       	</div>
       	
       	<a href="#"> Stock </a>
       	
       	<button class="dropdown-btn"> Supplier <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="/addsupplier"> Add New Supplier </a>
            <a href="/updatesupplier"> Update Supplier </a>
         </div>
         
         <button class="dropdown-btn"> Purchase <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="/ordernewstock"> Order </a>
            <a href="#"> Payment  </a>
            <a href="#"> Return </a>
         </div>
         
         <button class="dropdown-btn"> Transfer <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="#"> Transfer</a>
            <a href="#"> View </a>
         </div>
         
         <button class="dropdown-btn"> Offer  <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="/addoffer"> Add Offer </a>
            <a href="#"> Update Offer </a>
         </div>
         
      </div>
     
      <div class="header">
         <a href="#" class="logo"> EPOS </a>
         <div class="header-right">
            <a class="#" href="#"> Welcome ${userName} </a>
            <a href="/login"> Logout </a>
         </div>
      </div>
      <div class="content">
         <table>
				<tr>
		    		<td><a href="/addproduct">-Add Product</a></td>
		    		<td><a href="/addstore">-Add Store</a></td>
		    		<td><a href="/viewstock">-View Stock</a></td>
		    	</tr>
		    	<tr>
		    		<td><a href="#">-Payment</a></td>
		    		<td><a href="#">-Transfer</a></td>
		    		<td><a href="/ordernewstock">-Order Stock </a></td>
		    	</tr>
	   	</table>
      </div>
      <script>
         /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
         var dropdown = document.getElementsByClassName("dropdown-btn");
         var i;
         for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function() {
               this.classList.toggle("active");
               var dropdownContent = this.nextElementSibling;
               if (dropdownContent.style.display === "block") {
                  dropdownContent.style.display = "none";
               } else {
                  dropdownContent.style.display = "block";
               }
            });
         }
      </script>
   </body>
</html>