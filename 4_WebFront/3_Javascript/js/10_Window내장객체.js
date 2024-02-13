// window.setTimeout(함수, 지연시간(ms))
document.getElementById("btn1").addEventListener("click", function(){

    setTimeout(function(){
        alert("3초후 출력 확인");

    }, 3000);

})

// setInterval(함수, 지연시간(ms))
function clockFn(){
    const clock = document.getElementById("clock");
    clock.innerText = currentTime(); // 현재 시간 화면에 출력

    // 지연 시간 마다 반복(첫 반복도 지연 시간 후에 시작)
    // -> 페이지 로딩 후 1초 후 부터 반복(지연 -> 함수 -> 지연 -> 함수)
    interval = setInterval(function(){
        clock.innerText = currentTime();
    },1000);
}

clockFn(); // 함수 호출

// 현재 시간 문자열로 반환 함수
function currentTime(){
    const now = new Date();

    let hour = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();

    if(hour < 10) hour = "0" + hour;
    if(min < 10) min = "0" + min;
    if(sec < 10) sec = "0" + sec;

    return hour + " : " + min + " : " + sec;
}

// clearInterval
document.getElementById("stop").addEventListener("click",function(){
    clearInterval(interval);
})