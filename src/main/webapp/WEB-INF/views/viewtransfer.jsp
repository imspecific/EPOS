<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <title>View Transfer</title>
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
            margin-top: 70px;
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

         /*Table CSS*/
         table.table1,
         table.table2 {
            font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
            border: 2px solid #000000;
            background-color: #B0B0B0;
            width: 300px;
            height: 100px;
            text-align: center;
            border-collapse: collapse;
            column-width: 100%;
         }

         table.table1 td,
         table.table1 th,
         table.table2 td,
         table.table2 th {
            border: 1px solid #4A4A4A;
            padding: 3px 3px;
         }

         table.table1 tbody td table.table2 tbody td {
            font-size: 13px;
            color: #E6E6E6;
         }

         table.table1 tr:nth-child(even) {
            background: #888888;
         }

         table.table2 {
            width: 80%;
            height: 35px;
         }
      </style>
   </head>
   <body>
      <div class="sidenav">
         <a href="#">Home</a>
         <button class="dropdown-btn">EPOS Product <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="addemployee.jsp"> Add Category </a>
            <a href="updateemployee.jsp"> Add New Product </a>
            <a href="resetpassword.jsp"> Update Product </a>
         </div>
         <button class="dropdown-btn"> Store <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="addemployee.jsp">Add New Store</a>
            <a href="resetpassword.jsp">Update Store</a>
         </div>
         <a href="#"> Stock </a>
         <button class="dropdown-btn"> Supplier <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="stockreport.jsp"> Add New Supplier </a>
            <a href="profitlossreport.jsp"> Update Supplier </a>
         </div>
         <button class="dropdown-btn"> Purchase <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="stockreport.jsp"> Order </a>
            <a href="purchasereport.jsp"> Payment </a>
            <a href="profitlossreport.jsp"> Return </a>
         </div>
         <button class="dropdown-btn">Transfer <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="stockreport.jsp"> Transfer</a>
            <a href="purchasereport.jsp"> View </a>
         </div>
         <button class="dropdown-btn"> Offer <i class="fa fa-caret-down"></i>
         </button>
         <div class="dropdown-container">
            <a href="stockreport.jsp"> Add Offer </a>
            <a href="purchasereport.jsp"> Update Offer </a>
         </div>
      </div>
      <div class="header">
         <a href="#" class="logo">EPOS</a>
         <div class="header-right">
            <a class="#" href="#">Welcome</a>
            <a href="login">Logout</a>
         </div>
      </div>
      <div class="content">
         <table class="table2">
            <tr>
               <h2> View Transfer </h2>
            </tr>
            <tr>
               <td>
                  Store Id
               </td>
               <td>
                  <select name="storeid" id=""storeid"">
                     <option value="select"> Select </option>
                  </select>
               </td>
               <td>
                  <input type="submit" value="Search" /> &nbsp;&nbsp; <input type="submit" value="Cancel" />
               </td>
            </tr>
         </table>
         <br />
         <table class="table1">
            <tr>
		    		<th> Product Id </th>
		    		<th> Transfer Date</th>
		    		<th> Delivered Qty </th>
		    		<th> Pending Qty </th>
		    	</tr>
		    	<tr>
		    		<td> P0003 </td>
		    		<td> 2021-11-09 </td>
		    		<td>10</td>
		    		<td>0</td>
		    	</tr>
		    	<tr>
		    		<td colspan="4"><input type="submit" value="Cancel"/></td>
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