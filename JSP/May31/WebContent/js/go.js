function goProductReg(){
	location.href = "ProductRegController";
}
function goSnackReg(){
	location.href = "SnackRegController";
}
function goSnackDetail(no){
	location.href = "SnackDetailController?no=" + no;
}
function goProductDetail(no){
	location.href = "ProductDetailController?no=" + no;
}
function deleteSnack(no){
	var ok = confirm('沥富 昏力?');
	if (ok){
		location.href = "SnackDeleteController?no=" + no;
	}
}
function deleteProduct(no){
	var ok = confirm('沥富 昏力?');
	if (ok){
		location.href = "ProductDeleteController?no=" + no;
	}
}
