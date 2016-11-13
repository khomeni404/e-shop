<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<body class="td-color1" background="http://cdn.backgroundhost.com/backgrounds/subtlepatterns/diagonal_striped_brick.png">
Birth Date
<input type="text" name="birthDate" maxlength="12" value="" readonly="readonly" id="birthDate" class="text-style" onclick="javascript:NewCssCal('birthDate','ddMMyyyy')" />
<img src="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/svgs/fi-calendar.svg" height="25" width="25" border="0" style="cursor:pointer" title="Pick Date" onclick="javascript:NewCssCal('birthDate','ddMMyyyy')">

</body>

</@layout.se_app_layout>