<%--
  Created by IntelliJ IDEA.
  User: THINKPADX240
  Date: 2/25/2021
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>final exam</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
    <link rel="stylesheet" href="css/myCss.css" /></head>
<body>
<div class="container">
    <div class="row">
        <h2 class="text-center">Create new</h2>
    </div>

    <div class="row">

        <div class="col-md-12">
            <form method="post">
            <table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th>Color</th>
                    <th>Description</th>
                    <th>Category</th>
                </tr>
                </thead>

                <tbody>
                    <tr>
                        <td><input name="name"></td>
                        <td><input name="price"></td>
                        <td><input name="amount"></td>
                        <td><input name="color"></td>
                        <td><input name="description"></td>
                        <td><select name="category">
                            <option>computer</option>
                            <option>TV</option>
                            <option>mobile</option>
                        </select></td>
                        <td rowspan="2"><input type="submit" value="CREATE"></td>
                    </tr>

                </tbody>
            </table>
            </form>
        </div>
    </div>
</div>

</div>
</body>
<script>
    $(document).ready(function() {
        $('#datatable').dataTable();

        $("[data-toggle=tooltip]").tooltip();

    } );
</script>

</html>
