IITA.Merger = Class.create();

IITA.Merger.prototype = {
	initialize: function(left, right) {
		this.left=left;
		this.right=right;
// alert(this.left + "\n" + this.right);
	},
	
	copyMe: function(element) {
		element=$(element);
		var node=this.getNode(element);
		if (node==null) return;
		var source=this.getSourceList(node);
		var dest=this.getDestinationList(source);
		if (this.containsEntity(dest, node)) {
			return;
		}
		var dup=Element.clone(node, true);
		this.addToList(dest, dup);
		this.copyNames(dup);
	},
	
	moveMe: function(element) {
		element=$(element);
		var node=this.getNode(element);
		if (node==null) return;
		var source=this.getSourceList(node);
		var dest=this.getDestinationList(source);
		if (!this.containsEntity(dest, node)) {
			var dup=Element.clone(node, true);			
			this.addToList(dest, dup);
			this.copyNames(dup);
		}
		this.removeFromList(dest, node);
	},
	
	containsEntity: function(list, node) {
		var inputs=node.getElementsByTagName("input");
		var className, entityId;
		for (var i=0; i<inputs.length; i++) {
			var input=inputs[i];
			if (input.name.indexOf("preserveClass")!=-1)
				className=input.value;
			else if (input.name.indexOf("preserveId")!=-1)
				entityId=input.value;
		}
//		alert("Looking for existing " + className + " with id " + entityId);
		inputs=list.getElementsByTagName("input");
		for (var i=0; i<inputs.length; i++) {
			var input=inputs[i], nextInput=inputs[i+1];
			if (input.name.indexOf("preserveClass")!=-1) {
				if (className==input.value && entityId==nextInput.value)
					return true;
			}
		}
		return false;
	},
	
	addToList: function(list, node) {
		var li=document.createElement("li");
		list.appendChild(li);
		li.appendChild(node);
	},
	
	removeFromList: function(list, node) {
		Element.remove(node.parentNode);
	},
	
	// fix names of inputs for copying
	copyNames: function(node) {
		var inputs=node.getElementsByTagName("input");
		for (var i=0; i<inputs.length; i++) {
			var input=inputs[i];
			if (input.name.indexOf("left")!=-1)
				input.name=input.name.replace("left", "right");
			else
				input.name=input.name.replace("right", "left");
		}
	},
	
	// Find parent with class-name "merge-info"
	getNode: function(element) {
		while (element!=null && !element.hasClassName("merge-info")) {
			element=$(element.parentNode);
		}
		if (element.hasClassName("merge-info"))
			return element;
		else 
			return null;
	}, 
	
	// Find UL that contains this element
	getSourceList: function(element) {
		while (element!=null && element.tagName!="UL") {
			element=$(element.parentNode);
		}
		if (element.tagName=="UL")
			return element;
		else 
			return null;
	},
	
	// Find UL in the other TD with the same class-name
	getDestinationList: function(element) {
		var td=this.getOtherEntity(element);
		return td.getElementsBySelector("." + element.className)[0];
	},
	
	getOtherEntity: function(element) {
		while (element!=null && (element.id!="left-entity" && element.id!="right-entity")) {
			element=$(element.parentNode);
		}
		if (element.id=="left-entity") return this.right;
		if (element.id=="right-entity") return this.left;
		return null;
	}
};

var merger=new IITA.Merger($('left-entity'), $('right-entity'));
