var Statistics = function () {
	var toggleButton1 = function(obj,title,month,map) {
		var myChart = echarts.init(obj);
	    option = {
	    	    title : {
	    	        text: month+"月份"+title,
	    	    },
	    	    tooltip : {
	    	        trigger: 'axis'
	    	    },
	    	    toolbox: {
	    	        show : false,
	    	        feature : {
	    	            mark : {show: true},
	    	            dataView : {show: true, readOnly: false},
	    	            magicType : {show: true, type: ['line', 'bar']},
	    	            restore : {show: true},
	    	            saveAsImage : {show: true}
	    	        }
	    	    },
	    	    calculable : true,
	    	    xAxis : [
	    	        {
	    	            type : 'category',
	    	            boundaryGap : false,
	    	            data : [
	    	                    [#list map.keySet() as key]
	    	                    '${key}',
	    	                    [/#list]
	    	                    ]
	    	        }
	    	    ],
	    	    yAxis : [
	    	        {
	    	            type : 'value',
	    	            axisLabel : {
	    	                formatter: '{value}'
	    	            }
	    	        }
	    	    ],
	    	    series : [
	    	        {
	    	            name:'分红',
	    	            type:'line',
	    	            data:[
							[#list map.keySet() as key]
							'${map.get(key)}',
							[/#list]     
	    	            ],
	    	            
	    	        },
	    	        
	    	    ]
	    	};
	    myChart.setOption(option);
    }
	var toggleButton2 = function() {
        
    }
    return {

        init: function (obj,title) {
        	toggleButton1(obj,title,month);
        },

        initJQVMAP: function () {
           
        },

        initCalendar: function () {
            
        },

        initCharts: function () {
            
        },

        initMiniCharts: function () {
            

        },

        initChat: function () {
        	
        }

    };

}();