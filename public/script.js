$(document).ready(function(){
    window.changeRec = function(id){
        $("input[name='EDname"+id+"']").toggle();
	$("input[name='EDhomephone"+id+"']").toggle();
	$("input[name='EDphonenum"+id+"']").toggle();
	$("button[name='changeb"+id+"']").toggle();
	$("button[name='save"+id+"']").toggle();

	$("strong[name='str1"+id+"']").attr('data-bind',"text: EDnametxt");
	$("strong[name='str2"+id+"']").attr('data-bind',"text: EDhomephonetxt");
	$("strong[name='str3"+id+"']").attr('data-bind',"text: EDphonenumtxt");


	function AppViewModel() {
	    this.EDname = ko.observable($("input[name='EDname"+id+"']").val());
	    this.EDhomephone = ko.observable($("input[name='EDhomephone"+id+"']").val());
	    this.EDphonenum = ko.observable($("input[name='EDphonenum"+id+"']").val());
	    this.EDnametxt = ko.computed(function() {
		return this.EDname();    
	    }, this);
	    this.EDhomephonetxt = ko.computed(function() {
		return this.EDhomephone();    
	    }, this);

	    this.EDphonenumtxt = ko.computed(function() {
		return this.EDphonenum();    
	    }, this);


	}
	// Activates knockout.js
	ko.applyBindings(new AppViewModel());

	
    }
    
    window.saveChange = function(id){
	sqlRequest="EDname="+$("input[name='EDname"+id+"']").val()+"&EDhomephone="+$("input[name='EDhomephone"+id+"']").val()+"&EDphonenum="+$("input[name='EDphonenum"+id+"']").val();
        $("a[href='edit/"+id+"?").attr('href',"edit/"+id+"?" +sqlRequest);
	
	$("strong[name='str1"+id+"']").attr('data-bind',"");
	$("strong[name='str2"+id+"']").attr('data-bind',"");
	$("strong[name='str3"+id+"']").attr('data-bind',"");
	
    }
});
