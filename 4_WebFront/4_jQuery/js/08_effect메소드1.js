// show(), hide()

$("#hide-btn").on("click", function(){
    $("#img1").hide(500); // 1000ms == 1s
})

$("#show-btn").on("click", function(){
    $("#img1").show(500);
})

// fadeIn(), fadeOut()
$("#fadeIn-btn").on("click", function(){
    $("#img2").fadeIn(1000);
})

$("#fadeOut-btn").on("click", function(){
    $("#img2").fadeOut(1000);
})