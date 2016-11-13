<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<link href="../resources/plugins/jQueryTree-Multiselect/jquery.tree-multiselect.min.css"
      rel="stylesheet" type="text/css">
<form action="${ctx}/security/updateGroupAuthorities.se" method="post">
    <div class="row">
        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Aopf;&uopf;&topf;&hopf;&oopf;&ropf;&iopf;&topf;&yopf; &Aopf;&sopf;&sopf;&iopf;&gopf;&nopf;&mopf;&eopf;&nopf;&topf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-3 text-right">SELECT A GROUP</div>
                        <div class="col-md-4">
                            <select name="groupId" id="groupId" class="form-control se-select">
                                <#list groupList as group>
                                    <option value="${group.id}">${group.name}</option>
                                </#list>
                            </select>
                        </div>


                    </div>
                    <div class="form-row">

                        <div class="col-md-3"></div>
                        <div class="col-md-4">
                            <input type="submit" class="form-control btn btn-success"
                                   value="Assign Authorities to Group"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-4 se-in-msg"></div>
    </div>
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header se-header-bl">
                    &Aopf;&uopf;&topf;&hopf;&oopf;&ropf;&iopf;&topf;&yopf; &Sopf;&eopf;&lopf;&eopf;&copf;&topf;&iopf;&oopf;&nopf;
                </div>
                <div class="content">
                    <select id="authIds" name="authIds" multiple="multiple">
                        <#list authorityList as auth>
                                <option value="${auth.id}" data-section="All Authority">${auth.name}</option>
                        </#list>
                    </select>
                </div>
            </div>

        </div>
    </div>
</form>
</@layout.se_app_layout>

<script src="../resources/js/jquery-1.11.1.js"></script>
<script src="../resources/js/jQueryPlugin/jquery-ui.js"></script>
<script src="../resources/plugins/jQueryTree-Multiselect/jquery.tree-multiselect.min.js"></script>
<script type="text/javascript">
    var options = {
        sortable: true,
        startCollapsed: true
    };
    $("select#authIds").treeMultiselect(options);


</script>