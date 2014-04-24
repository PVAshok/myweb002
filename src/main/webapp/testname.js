$(function() {

	var input1 = $("#name");
	
	
	input1.bind({
		blur : function() {
			$("#lable1").html("");
			if (input1.val() ==""||input1.val()==null) {
				alert("name can't be null!");
				input1[0].focus();
				return ;
			} else {

				var url = "test_json!testjson?jsname="
						+ input1.val();
				$.getJSON(url, function(data) {
					if (data.msg == "true") {

						$("#lable1").html("this name is already exist!");
						input1[0].focus();



					} else {
						$("#lable1").html("OK ");
					}
					

				});
			}
		}
	});

	}
)
