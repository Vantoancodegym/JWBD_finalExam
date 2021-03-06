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
        <h2 class="text-center">Products list</h2>
        <form method="post" action="/products?action=find" style="margin-left: 20px">
            <input name="name" placeholder="input name">
            <input type="submit" value="SEARCH">
        </form>
    </div>
    <div class="row">

        <div class="col-md-12">


            <table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th>Color</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th colspan="2"><a href="/products?action=create">CREATE NEW</a></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${list}" var="product">
                <tr>
                    <td>${product.getName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getAmount()}</td>
                    <td>${product.getColor()}</td>
                    <td>${product.getDescription()}</td>
                    <td>${product.getCategory_type()}</td>
                    <td><a href="/products?action=edit&id=${product.getId()}"><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></a></td>
                    <td><a href="/products?action=delete&id=${product.getId()}"
                    onclick="return confirm('Do you want to delete')"><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></a></td>
                </tr>
                </c:forEach>

                </tbody>
            </table>


        </div>
    </div>
</div>

<%--<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="false">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>--%>
<%--                <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <div class="form-group">--%>
<%--                    <input class="form-control " type="text" placeholder="Tiger Nixon">--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>

<%--                    <input class="form-control " type="text" placeholder="System Architect">--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>


<%--                    <input class="form-control " type="text" placeholder="Edinburgh">--%>

<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="modal-footer ">--%>
<%--                <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <!-- /.modal-content -->--%>
<%--    </div>--%>
<%--    <!-- /.modal-dialog -->--%>
<%--</div>--%>



<%--<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>--%>
<%--                <h4 class="modal-title custom_align" id="Heading2">Delete this entry</h4>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>

<%--                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>--%>

<%--            </div>--%>
<%--            <div class="modal-footer ">--%>
<%--                <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Yes</button>--%>
<%--                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <!-- /.modal-content -->--%>
<%--    </div>--%>
<%--    <!-- /.modal-dialog -->--%>
</div>
</body>
<script>
    $(document).ready(function() {
        $('#datatable').dataTable();

        $("[data-toggle=tooltip]").tooltip();

    } );
</script>

</html>
