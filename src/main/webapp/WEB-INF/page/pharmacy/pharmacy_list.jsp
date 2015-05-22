<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
     <table id="datatable"></table>
    <script>
        $(function () {
             $('#datatable').bootstrapTable({
                method: 'get',
                url: 'pharmacy/list',
                cache: false,
                 striped: true,
                pagination: true,showHeader:"false",
                pageSize: 25,
                pageList: [10, 25, 50],
                showColumns: true,
                showRefresh: true,
                sidePagination:"server",
                columns: [{
                    field: 'id',
                    checkbox: true
                }, {
                    field: 'name',
                    title: 'name'
                }, {
                    field: 'remarks',
                    title: 'remarks'
                }, {
                    field: 'registerDate',
                    title: 'registerDate'
                }, {
                    field: 'phone',
                    title: 'phone'
                }, {
                    field: 'address',
                    title: 'address'
                }]
            });
        });
    </script>
