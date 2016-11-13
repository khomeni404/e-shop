<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<link href="../resources/plugins/jQueryTree-Multiselect/jquery.tree-multiselect.min.css"
      rel="stylesheet" type="text/css">
<form action="${ctx}/security/updateUserGroups.se" method="post">
    <div class="row">
        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Gopf;&ropf;&oopf;&uopf;&popf; &Aopf;&sopf;&sopf;&iopf;&gopf;&nopf;&mopf;&eopf;&nopf;&topf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-3 text-right">USERS</div>
                        <div class="col-md-4">
                            <select name="userId" id="userId" class="form-control se-select">
                                <#list userList as user>
                                    <option value="${user.id}">${user.name} : ${user.getDiscriminatorValue()}</option>
                                </#list>
                            </select>
                        </div>


                    </div>
                    <div class="form-row">

                        <div class="col-md-3"></div>
                        <div class="col-md-4">
                            <input type="submit" class="form-control btn btn-success"
                                   value="Assign Groups to User"/>
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
                    &Gopf;&ropf;&oopf;&uopf;&popf; &Sopf;&eopf;&lopf;&eopf;&copf;&topf;&iopf;&oopf;&nopf;
                </div>
                <div class="content">
                    <select id="groupIds" name="groupIds" multiple="multiple">
                        <#list groupList as group>
                                <option value="${group.id!}" data-section="All Group">${group.name!}</option>
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
    $("select#groupIds").treeMultiselect(options);

</script>