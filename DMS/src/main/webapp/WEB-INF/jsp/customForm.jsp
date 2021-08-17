<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Questions</title>
</head>

<body>
<jsp:include page="facultylogin.jsp"/>
<div>
    <form action="/processCustomForm" method="post">
        <div>
            Enter Form Name:
            <input type="text" name="formName" id="q_form_name" value="">
        </div>

        <div>
            Select No. of Question:
            <input type="number" name="q_no" id="q_no" value="" onchange="updateQuestionForm(this.value)">
        </div>

        <div class="question_data" id="question_data">

        </div>

        <input type="submit" value="submit">
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
    function updateQuestionForm(val) {
        $("#question_data").empty();
        var qcount = 0;
        if(val>0)
        {
            qcount = parseInt(val) + 1;
        }
        qdata = "";
        for (i = 1; i < qcount; i++) {
            qdata += '<div class="questions question_'+i+'" name= "question_'+i+'">';
            qdata += '<input type="text" name="q_desc_'+i+'" placeholder="Enter question description">';
            qdata += '<select name="q_type_'+i+'" id="q_type_'+i+'" class="question-select" name="q_type_'+i+'">';
            qdata += '<option value="">Select Question Type</option>';
            qdata += '<option value="1">Numeric</option>';
            qdata += '<option value="2">Multiple choice</option>';
            qdata += '<option value="3">Text</option>';
            qdata += '</select><span id="q_details_'+i+'"></span></div>';
        }

        $("#question_data").append(qdata);
    }

    $(document).on('change','.question-select',function(){
        var val = $(this).val();
        selectStr = $(this).attr('id');
        var ids = selectStr.replace('q_type_','');
        $("#q_details_"+ids).empty();
        qdata = "";
        if(val==2 || val==4){
            qdata += '<input type="text" name="q_desc_'+ids+'_detail_value_1">';
            qdata += '<input type="text" name="q_desc_'+ids+'_detail_value_2">';
            qdata += '<input type="text" name="q_desc_'+ids+'_detail_value_3">';
            qdata += '<input type="text" name="q_desc_'+ids+'_detail_value_4">';
        }
        $("#q_details_"+ids).append(qdata);
    });

</script>

</body>
</html>
