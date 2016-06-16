window.onload=function()
{
	//试卷标题以及试卷描述
	theTestHeader();
	questionChoose();
	
}
function theTestHeader()
{
	var testName=document.getElementById("testName");	
	var testDescrible=document.getElementById("testDescrible");	

	testName.onfocus=function()
	{
		testName.style.background="#FDF9CD";
		testName.style.border="1px solid #ccc";
	};
	
	testDescrible.onfocus=function()
	{
		testDescrible.style.background="#FDF9CD";
		testDescrible.style.border="1px solid #ccc";
	};
	testName.onblur=function()
	{
		testName.style.background="#fff";
		testName.style.border="none";
	};
	testDescrible.onblur=function()
	{
		testDescrible.style.background="#fff";
		testDescrible.style.border="none";
	};
	testName.onmouseover=function()
	{
		testName.style.background="#FDF9CD";
	};
	testDescrible.onmouseover=function()
	{
		testDescrible.style.background="#FDF9CD";
	};
	testName.onmouseout=function()
	{
		testName.style.background="#fff";
	};
	testDescrible.onmouseout=function()
	{
		testDescrible.style.background="#fff";
	};
};
function questionChoose()
{
	var singleChoice=document.getElementById("singleChoice");
	var multipleChoice=document.getElementById("multipleChoice");
	var i=1, j=1, k=1;
	singleChoice.onclick=function()
	{
		var	questionRadio=document.getElementById("questionRadio"+i);
		questionRadio.style.display="block";
		i++;
		k++;
	};
	multipleChoice.onclick=function()
	{
		var	questionCheckbox=document.getElementById("questionCheckbox"+j);
		questionCheckbox.style.display="block";
		j++;
		k++;
	};
};