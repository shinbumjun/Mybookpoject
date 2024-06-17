$('div.error').empty();
   
   var $xml = $(data);
   
   var disableTable = $xml.find('resultCode').text().trim() != '00';
   
   if (disableTable) {
      $('div.error').empty().append("이용가능한 대기정보가 없습니다.");
      return;
   }
   
   console.log("대기정보 테이블 갱신");resourceresource
   
   var $table = $('.table');
   
   var $theadTr = "";
   $theadTr += "<tr>";
   
   $xml.find('items > item:first-child ').children().each(function(index,node) {

      var colTitle = "";
      
      switch(node.tagName) {
      case "dataTime" :
         colTitle = "시간정보"; break;
      case "seoul":
         colTitle = "서울"; break;
      case "busan":
         colTitle = "부산"; break;
      case "daegu":
         colTitle = "대구"; break;
      case "incheon":
         colTitle = "인천"; break;
      case "gwangju":
         colTitle = "광주"; break;
      case "daejeon":
         colTitle = "대전"; break;
      case "ulsan":
         colTitle = "울산"; break;
      case "gyeonggi":
         colTitle = "경기"; break;
      case "gangwon":
         colTitle = "강원"; break;
      case "chungbuk":
         colTitle = "충북"; break;
      case "chungnam":
         colTitle = "충남"; break;
      case "jeonbuk":
         colTitle = "전북"; break;
      case "jeonnam":
         colTitle = "전남"; break;
      case "gyeongbuk":
         colTitle = "경북"; break;
      case "gyeongnam":
         colTitle = "경남"; break;
      case "jeju":
         colTitle = "제주"; break;
      case "sejong":   
         colTitle = "세종"; break;
      default:
         colTitle = ""; break;
      }
      
      if (colTitle != "") {
         $theadTr += "<th>" + colTitle + "</th>";
      }
      
   });
   
   $theadTr += "</tr>";
   
   $table.find('thead').empty().append($theadTr);
   
   var $tbodyTr = "";
   
   $xml.find('items').children().each(function(index,node) {
   
      $tbodyTr += "<tr>";
   
      $item = $(node);
      
      $item.children().each(function(index,node) {
         
         if (node.tagName != "itemCode" && node.tagName != "dataGubun") {

            $tbodyTr += "<td>" + $(node).text().trim();
            
            if (node.tagName != "dataTime") {

               var state = "";
               
               if ($(node).text().trim() == "") {
                  state = "X";
               } else if ($(node).text().trim() < 20) {
                  state = "좋음";
               } else if ($(node).text().trim() < 30) {
                  state = "보통";
               } else {
                  state = "나쁨";
               }
               
               $tbodyTr += "<br>" + state;
            }
            
            $tbodyTr += "</td>";
         }
         
      });
      
      $tbodyTr += "</tr>";
      
   });
   
   $table.find('tbody').empty().append($tbodyTr);