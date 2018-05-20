
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
	const {performance} = require('perf_hooks');
	
		var startDate = new Date();
		var perfStart =performance.now();
		fibonacci_loop(params.num);
		var endDate   = new Date();
		var perfEnd = performance.now();
		var seconds = (endDate.getTime() - startDate.getTime()) / 1000;
		var withTime = endDate - startDate;
		var timeInterval = perfEnd - perfStart
	
		//"start,end, total";
		result = startDate + ", " + endDate + ", " + seconds + ", " + timeInterval + ", " + withTime;
	
	return {
		result
	};
}