
//fibonacci function using while loop 
function fibonacci_loop(num){
  var a = 1, b = 0, temp;

  while (num >= 0){
    temp = a;
    a = a + b;
    b = temp;
    num--;
  }

  return b;
}

function main(params){
	
		var startDate = new Date();
		fibonacci_loop(params.num);
		var endDate   = new Date();
		var seconds = (endDate.getTime() - startDate.getTime()) / 1000;
	
		//"start,end, total";
		result = startDate + ", " + endDate + ", " + seconds;
	
	return {
		result
	};
}