function showPrice(){
    //Lấy id select
    var x = document.getElementById("getvalue");
    //Khi có sự thay đổi option trong select, lấy thuộc tính data-price
    var res = x.options[x.selectedIndex].getAttribute('data-price');
    //Đổ dữ liệu vừa lấy lên đơn giá
    document.getElementById("dongia").value = res;

}

function LoginMess(){
    var option = confirm("Logout?");
    if(option === true){
        window.location.href = 'login';
    }
}

function showMessP(id){
    var option = confirm("Delete id = "+id+"?");
    if(option === true){
        window.location.href = 'deleteproduct?pid='+id;
    }
}

function showMessU(id){
    var option = confirm("Delete id = "+id+"?");
    if(option === true){
        window.location.href = 'deleteuser?uid='+id;
    }
}

function showMessE(id){
    var option = confirm("Delete id = "+id+"?");
    if(option === true){
        window.location.href = 'deletemanager?eid='+id;
    }
}
function showMessI(id){
    var option = confirm("Delete id = "+id+"?");
    if(option === true){
        window.location.href = 'deleteinvoice?iid='+id;
    }
}

