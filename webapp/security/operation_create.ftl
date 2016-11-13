<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <form action="${ctx}/security/saveOperation.se" method="post">
        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Oopf;&popf;&eopf;&ropf;&aopf;&topf;&iopf;&oopf;&nopf; &Copf;&ropf;&eopf;&aopf;&topf;&eopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-3 text-right">OPERATION NAME.</div>
                        <div class="col-md-4">
                            <input type="text" name="name" class="form-control"
                                   value=""/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-3 text-right">OPERATION NAME.</div>
                        <div class="col-md-4">
                            <select name="moduleId" id="moduleId" class="form-control se-select">
                                <#list moduleList as module>
                                    <option value="${module.id!}">${module.name!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-3 text-right">OPERATION DESCRIPTION</div>
                        <div class="col-md-4">
                            <textarea name="description" id="description" cols="5" class="form-control se-textarea"></textarea>
                        </div>
                        <div class="col-md-3"><input type="submit" class="form-control btn btn-success"
                                                     value="Save"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</@layout.se_app_layout>