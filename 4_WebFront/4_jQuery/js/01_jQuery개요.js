// JS와 jQuery 차이점

// 배경 : black
// 글자색 : yellow
// 글자 크기 : 20px

// javascript
document.querySelector("#jsBtn").addEventListener("click", e => {
    e.target.style.backgroundColor = "black";
    e.target.style.color = "yellow";
    e.target.style.fontSize = "20px";
})

// jQuery
$("#jQueryBtn").on("click", function(){
    $(this).css("backgroundColor", "black").css("color", "yellow").css("fontSize", "20px");
})


// window.onload 확인
window.onload = function(){ // 문서 로딩이 완료된 후 수행
    console.log("1");
}

// window.onload 중복 작성 -> 앞서 작성한 window.onload를 덮어 씌움
window.onload = function(){ 
    console.log("3");
}

console.log("2");

// ready() 함수 확인
$(document).ready(function(){

    $("#readyTest").on("click", function(){
        alert("클릭 되었습니다.");
    })
})

// ready() 중복 작성 -> 작성한 모든 내용이 적용됨
$(document).ready(function(){
    document.getElementById("readyTest").style.color = "red";
})

// ready() 함수 다른 형태
$(function(){
    console.log("ready() 함수의 다른 형태");
})

// ready() + 화살표 함수
$( ()=>{ console.log("이렇게도 됩니다."); } )