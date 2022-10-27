{
    /* <div class="mb-3">
    <label for="formGroupExampleInput" class="form-label">파일1</label>
    <input type="file" class="form-control" name="files" id="files">
    </div> */
}

let count = 1;
$("#fileAdd").click(function () { // 파일 추가하는 input 태그 생성
    // console.log("나와라")
    let label = ' <label for="formGroupExampleInput" class="form-label">파일' + count + '</label> ';
    let input = ' <input type="file" class="form-control" name="files" id="files"> ';
    $("#File").append(label);
    $("#File").append(input);
    count++;

    if (count > 1) { // 파일 추가 생기면 삭제 버튼 보이기
        $("#fileDel").show();
    }

    if (count > 6) { // 파일을 5개 이상 추가시
        $("#File label:last").remove();
        $("#File input:last").remove();
        swal("파일은 최대 5개까지 가능합니다.", "You clicked the button!", "info");
        count = 6;
        return;
    }
    console.log("add count: " + count);
})

$("#fileDel").click(function () { // 파일 추가하는 input 태그 삭제
    $("#File label:last").remove();
    $("#File input:last").remove();
    count--;
    // if(count = 1){
    //     $("#fileDel").hide();
    // }
    if (count < 2) { // 파일 추가하는 input 태그 없을시 삭제 버튼 안보이기
        $("#fileDel").hide();
        count = 1;
    }
    console.log("delete count: " + count);
})