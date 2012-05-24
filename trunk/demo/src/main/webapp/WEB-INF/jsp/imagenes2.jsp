<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>


 
 <html>
 <head>
 
 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-image-gallery.min.css">
	<!--[if lt IE 7]><link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-ie6.min.css"><![endif]-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload-ui.css">
	<style type="text/css">body {padding-top: 80px;}</style>

 </head>
<body>
   
<div class="container">
    <div class="page-header">
        <h1>jQuery File Upload Demo</h1>
    </div>
    <blockquote>
        <p>Multiple Upload</p>
    </blockquote>
    <br>
    <form id="fileupload" action="carga.htm" method="POST" enctype="multipart/form-data">
        <div class="row">
            <div class="span16 fileupload-buttonbar">
                <div class="progressbar fileupload-progressbar fade"><div style="width:0%;"></div></div>
                <span class="btn success fileinput-button">
                    <span>Add files...</span>
                    <input type="file" name="files[]" multiple>
                </span>
                <button type="submit" class="btn primary start">Start upload</button>
                <button type="reset" class="btn info cancel">Cancel upload</button>
                <button type="button" class="btn danger delete">Delete selected</button>
                <input type="checkbox" class="toggle">
            </div>
        </div>
        <br>
        <div class="row">
            <div class="span16">
                <table class="zebra-striped"><tbody class="files"></tbody></table>
            </div>
        </div>
    </form>
    <div class="well">
        <h3>Demo Notes</h3>
        <ul>
            <li>The maximum file size for uploads in this demo is <strong>5 MB</strong> (default file size is unlimited).</li>
            <li>Only image files (<strong>JPG, GIF, PNG</strong>) are allowed in this demo (by default there is no file type restriction).</li>
            <li>Uploaded files will be deleted automatically after <strong>5 minutes</strong> (demo setting).</li>
            <li>You can <strong>drag &amp; drop</strong> files from your desktop on this webpage with Google Chrome, Mozilla Firefox and Apple Safari.</li>
            <li>Please refer to the <a href="https://github.com/blueimp/jQuery-File-Upload">project website</a> and <a href="https://github.com/blueimp/jQuery-File-Upload/wiki">documentation</a> for more information.</li>
        </ul>
    </div>
</div>
<!-- gallery-loader is the loading animation container -->
<div id="gallery-loader"></div>
<!-- gallery-modal is the modal dialog used for the image gallery -->
<div id="gallery-modal" class="modal hide fade">
    <div class="modal-header">
        <a href="#" class="close">&times;</a>
        <h3 class="title"></h3>
    </div>
    <div class="modal-body"></div>
    <div class="modal-footer">
        <a class="btn primary next">Next</a>
        <a class="btn info prev">Previous</a>
        <a class="btn success download" target="_blank">Download</a>
    </div>
</div>
<script>
var fileUploadErrors = {
    maxFileSize: 'File is too big',
    minFileSize: 'File is too small',
    acceptFileTypes: 'Filetype not allowed',
    maxNumberOfFiles: 'Max number of files exceeded',
    uploadedBytes: 'Uploaded bytes exceed file size',
    emptyResult: 'Empty file upload result'
};
</script>
<script id="template-upload" type="text/html">
{% for (var i=0, files=o.files, l=files.length, file=files[0]; i<l; file=files[++i]) { %}
    <tr class="template-upload fade">
        <td class="preview"><span class="fade"></span></td>
        <td class="name">{%=file.name%}</td>
        <td class="size">{%=o.formatFileSize(file.size)%}</td>
        {% if (file.error) { %}
            <td class="error" colspan="2"><span class="label important">Error</span> {%=fileUploadErrors[file.error] || file.error%}</td>
        {% } else if (o.files.valid && !i) { %}
            <td class="progress"><div class="progressbar"><div style="width:0%;"></div></div></td>
            <td class="start">{% if (!o.options.autoUpload) { %}<button class="btn primary">Start</button>{% } %}</td>
        {% } else { %}
            <td colspan="2"></td>
        {% } %}
        <td class="cancel">{% if (!i) { %}<button class="btn info">Cancel</button>{% } %}</td>
    </tr>
{% } %}
</script>
<script id="template-download" type="text/html">
{% for (var i=0, files=o.files, l=files.length, file=files[0]; i<l; file=files[++i]) { %}
    <tr class="template-download fade">
        {% if (file.error) { %}
            <td></td>
            <td class="name">{%=file.name%}</td>
            <td class="size">{%=o.formatFileSize(file.size)%}</td>
            <td class="error" colspan="2"><span class="label important">Error</span> {%=fileUploadErrors[file.error] || file.error%}</td>
        {% } else { %}
            <td class="preview">{% if (file.thumbnail_url) { %}
                <a href="{%=file.url%}" title="{%=file.name%}" rel="gallery"><img src="{%=file.thumbnail_url%}"></a>
            {% } %}</td>
            <td class="name">
                <a href="{%=file.url%}" title="{%=file.name%}" rel="{%=file.thumbnail_url&&'gallery'%}">{%=file.name%}</a>
            </td>
            <td class="size">{%=o.formatFileSize(file.size)%}</td>
            <td colspan="2"></td>
        {% } %}
        <td class="delete">
            <button class="btn danger" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}">Delete</button>
            <input type="checkbox" name="delete" value="1">
        </td>
    </tr>
{% } %}
</script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="${pageContext.request.contextPath}/js/vendor/jquery.ui.widget.js"></script>
<!-- The Templates and Load Image plugins are included for the FileUpload user interface -->
<script src="${pageContext.request.contextPath}/js/tmpl.min.js"></script>
<script src="${pageContext.request.contextPath}/js/load-image.min.js"></script>
<!-- Bootstrap Modal and Image Gallery are not required, but included for the demo -->
<script src="${pageContext.request.contextPath}/js/bootstrap-modal.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-image-gallery.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="${pageContext.request.contextPath}/js/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.fileupload-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/application.js"></script>
<!-- The XDomainRequest Transport is included for cross-domain file deletion for IE8+ -->
<!--[if gte IE 8]><script src="cors/jquery.xdr-transport.js"></script><![endif]-->
		
	
</body>
</html>
