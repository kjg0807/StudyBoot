console.log("memberAdd");

$("#all").click(function (e) {

    let ch = $(this).prop("checked");

    $(".check").prop("checked", ch);


})

$(".check").click(function () {

    //let flag=true;
    $("#all").prop("checked", true);

    $(".check").each(function (idx, item) {
        let ch = $(item).prop("checked")
        if (!ch) {
            //flag=false;
            $("#all").prop("checked", false);
            console.log(ch);
            return false;
        }
    });
});
//id, pw, pwEquals, name, email
let results = [false, false, false, false, false];

//// ID Check
$("#inputId").blur(function () {
    let id = $("#inputId").val();
    console.log("start")
    let result = nullCheck(id, $("#inputIdResult"), "ID는");
    results[0] = result;
    console.log("ID result: " + result)

    //아이디 중복 확인 중복시 1 리턴, 중복x 0 리턴
    // 강사님 코드
    // $.get("URL?param1=값&param2=값", callback function)
    $.get("./getIdCheck?id=" + id, function (data) {
        console.log("rs? data: " + data);
        if (data == '0') {
            // if (id == "") {
            //     $("#id_feedback").html("빈칸은 사용할 수 없음");
            //     $("#id_feedback").attr("color", "#dc3545");
            //     return;
            // }
            $("#id_feedback").html("사용 가능한 ID");
            $("#id_feedback").attr("color", "#2fb380");
        }
        else {
            $("#id_feedback").html("이미 사용중인 ID");
            $("#id_feedback").attr("color", "#dc3545");
        }
    });


    // let mbId = $("#inputId").val();
    // $.ajax({
    //     url: './getIdCheck?id='+mbId,
    //     type: "get",
    //     data: { inputId: mbId },
    //     dataType: 'text',
    //     success: function (result) {
    //         if (result == 1) {
    //             $("#id_feedback").html("이미 사용중인 아이디입니다.");
    //             $("#id_feedback").attr("color", "#dc3545");
    //             idcheck = false;
    //         }
    //         else {
    //             $("#id_feedback").html("사용할 수 있는 아이디입니다.");
    //             $("#id_feedback").attr("color", "#2fb380");
    //             idcheck = true;
    //         }
    //     },
    //     error: function (textStatus, errorThrown) {
    //         alert("서버 요청 실패");
    //         console.log(textStatus);
    //         console.log(errorThrown);
    //     }
    // })
});

//// pw check
$("#inputPw").blur(function () {
    let result = nullCheck($("#inputPw").val(), $("#inputPwResult"), "PW는");
    results[1] = result;
    $("#inputPwCheck").val("");
    results[2] = false;
    $("#inputPwCheckResult").html("");
})

//// pw Equal Check
$("#inputPwCheck").blur(function () {
    let result = equals($("#inputPw").val(), $("#inputPwCheck").val());
    if (result) {
        $("#inputPwCheckResult").html("정상")
    } else {
        $("#inputPwCheckResult").html("PW가 틀립니다");
    }
    results[2] = result;
})

//// name check
$("#inputName").blur(function () {
    let result = nullCheck($("#inputName").val(), $("#inputNameResult"), "Name은")
    results[3] = result;
})

//// email check
$("#inputEmail").blur(function () {
    let result = nullCheck($("#inputEmail").val(), $("#inputEmailResult"), "Email은")
    results[4] = result;
})

$("#joinButton").click(function () {

    if (results.includes(false)) {
        alert("필수 입력은 다 입력해");
    } else {
        // alert("전송");
        $("#joinForm").submit();
    }
});