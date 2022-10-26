console.log("start");

$("#btn").click(function () {
    console.log("id btn click");
});

$(".but").click(function () {
    console.log("class but click");
});

$("#test").on("click", "#btn2", function () {
    console.log("click move test");
});
