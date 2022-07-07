//
// window.onload=function (){
//     let tableData="<tr id=\"table-tr\">\n" +
//         "            <td>序号</td>\n" +
//         "            <td>品牌名称</td>\n" +
//         "            <td>企业名称</td>\n" +
//         "            <td>排序</td>\n" +
//         "            <td>品牌介绍</td>\n" +
//         "            <td>状态</td>\n" +
//         "            <td><a href=\"#\">添加</a></td>\n" +
//         "        </tr>";
//
//
//
//     axios({
//         method:"Post",
//         url:"http://localhost:8080/Demo2/SelectAllServlet",
//         data:""
//     }).then(function (resp) {
//         let brands = resp.data;
//         for (let i = 0; i < brands.length; i++) {
//             let brand = brands[i];
//             tableData +="<tr>\n" +
//                 "            <td>"+brand.id+"</td>\n" +
//                 "            <td>"+brand.brandName+"</td>\n" +
//                 "            <td>"+brand.companyName+"</td>\n" +
//                 "            <td>"+brand.ordered+"</td>\n" +
//                 "            <td>"+brand.description+"</td>\n" +
//                 "            <td>"+brand.status+"</td>\n" +
//                 "            <td><a href=\"#\">添加</a></td>\n" +
//                 "        </tr>"
//         }
//         document.getElementById("brand_table").innerHTML=tableData;
//
//
//     })
// }
//
//
//
