{
    /* <div class="mb-3">
    <label for="formGroupExampleInput" class="form-label">파일1</label>
    <input type="file" class="form-control" name="files" id="files">
    </div> */
}

let count = 1;
$("#fileAdd").click(function () {
    // console.log("나와라")
    let label = ' <label for="formGroupExampleInput" class="form-label">파일' + count + '</label> ';
    let input = ' <input type="file" class="form-control" name="files" id="files"> ';
    $("#File").append(label);
    $("#File").append(input);
    count++;
    if (count > 1) {
        $("#fileDel").show();
    }
    if (count > 6) {
        $("#File label:last").remove();
        $("#File input:last").remove();
        swal("파일은 최대 5개까지 가능합니다.", "You clicked the button!", "info");
        count = 6;
        return;
    }
    console.log("add count: " + count);
})

$("#fileDel").click(function () {
    $("#File label:last").remove();
    $("#File input:last").remove();
    count--;
    // if(count = 1){
    //     $("#fileDel").hide();
    // }
    if (count < 2) {
        $("#fileDel").hide();
        count = 1;
    }
    console.log("delete count: " + count);
})