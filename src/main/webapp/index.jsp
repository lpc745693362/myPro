
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="application/javascript" src="/common/js/index.js"></script>
<script type="application/javascript" src="/common/js/jquery-1.10.1.min.js"></script>

<html>
    <head>
        <title>Init Page</title>
    </head>
    <body>
        <h2>Hello World!</h2>

        <form action="/test/test.action" method="post">
            <input type="submit" value="测试"/>
        </form>

        <hr style="height:1px; border:none; border-top:1px dashed #0066CC;" />

        <h2>上传</h2>

        <form action="/test/fileUpload.action" method="post" enctype="multipart/form-data">
            file：<input type="file" name="file"/>
            <br/><br/>
            desc：<input type="text" name="desc"/>
            <br/><br/>
            <input type="submit" value="上传">
        </form>

        <hr style="height:1px; border:none; border-top:1px dashed #0066CC;" />

        <h2>下载</h2>

        tang.jpc：<a href="/test/fileDownload.action">点击下载</a><br/>

        <h2>导出</h2>

        <a href="/test/export_export.action">导出无水印</a><br/>
        <a href="/test/export_exportSY.action">导出有水印</a><br/>

        <br/>
        <hr style="height:1px; border:none; border-top:1px dashed #0066CC;" />
        <br/>

        <form action="/test/importExcel.action" method="post" id="excelForm" enctype="multipart/form-data">
            excel：<input id="excelFile" name="excelFile" type="file"/><br/>
            <input type="button" value="导入Excel" onclick="importExcel()">
        </form>

    </body>
</html>
