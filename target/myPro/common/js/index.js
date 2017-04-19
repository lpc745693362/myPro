/**
 * Created by liupengcheng1 on 2017/4/18.
 */

function importExcel() {
    var pathName = $("#excelFile").val();
    if (isNull(pathName)) {
        alert("please import excel file");
        return false;
    }
    var suffix = pathName.substring(pathName.lastIndexOf('.') + 1, pathName.length);
    if ((suffix != "xls") && (suffix != "xlsx")) {
        alert("file type error");
        return false;
    }
    $("#excelForm").submit();
}

function isNull(str) {
    if (str == undefined || str == null || Trim(str).length < 1) {
        return true;
    }
    return false;
}

function Trim(str) {
    return str.replace(/^\s*/, '').replace(/\s*$/, '');
}

