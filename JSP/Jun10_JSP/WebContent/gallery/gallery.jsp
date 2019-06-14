<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>GALLERY</title>
</head>
<body>
	<table id="galleryTable">
		<tr><td>
		<c:forEach var="g" items="${galleries }">
			<table id="fileTable">
				<tr>
					<td align="center">
						<img src="file/${g.file }" onclick="goGalleryDetail(${g.no}, ${curPage });">
					</td>
				</tr>
				<tr>
					<td align="center">
						${g.id }
					</td>
				</tr>
				<tr>
					<td align="center">
						${g.title }
					</td>
				</tr>
				<c:if test="${sessionScope.m.id == g.id }">
					<tr>
						<td align="center">
							<button onclick="goGalleryDetail(${g.no}, ${curPage });">수정</button>
							<button onclick="fileDelete(${g.no}, '${g.file}', ${curPage });">삭제</button>
						</td>
					</tr>
				</c:if>
			</table>
		</c:forEach>
		</td></tr>
		<tr>
			<td colspan="2" align="center">
				<c:if test="${curPage != 1 and curPage != null }"><a href="GalleryPageController?p=${curPage - 1 }"> ＜ </a></c:if>
				<c:forEach var="p" begin="1" end="${pageCount }">&nbsp;<a href="GalleryPageController?p=${p }" >${p }</a>&nbsp;</c:forEach>
				<c:if test="${curPage != pageCount and pageCount != null}"><a href="GalleryPageController?p=${curPage + 1 }"> ＞ </a></c:if>
			</td>
		</tr>
	</table>
	
	<table id="galleryUploadTableArea">
		<c:if test="${sessionScope.m != null }">
			<tr>
				<td align="center">
					<form action="GalleryUploadController" method="post" enctype="multipart/form-data" name="galleryUploadForm" onsubmit="return galleryUploadCheck();">
						<input name="token" value="${token }" type="hidden">
						<table id="galleryUploadTable">
							<tr>
								<td><input name="title" id="gutTitle" maxlength="20" placeholder="제목" autocomplete="off"></td>
								<td rowspan="2"><button>업로드</button></td>
							</tr>
							<tr>
								<td><input name="file" id="gutFile" type="file"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</c:if>
		<tr>
			<td align="center">
				<form action="GallerySearchController" name="gallerySearchForm" onsubmit="return gallerySearchCheck();">
					<table id="gallerySearchTable">
						<tr>
							<td><input name="search" id="gutTitle" maxlength="20" placeholder="제목" autocomplete="off"></td>
							<td><button>검색</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	
</body>
</html>