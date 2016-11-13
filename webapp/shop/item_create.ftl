<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<form action="${ctx}/shop/saveItem.se" method="post">
    <div class="row">

        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Iopf;&topf;&eopf;&mopf; &Copf;&ropf;&eopf;&aopf;&topf;&eopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-2 text-right">ITEM NAME.</div>
                        <div class="col-md-3">
                            <input type="text" name="name" class="form-control"
                                   value="Rice"/>
                        </div>

                        <div class="col-md-2 text-right">ITEM CODE</div>
                        <div class="col-md-3">
                            <input type="text" name="code" class="form-control"
                                   value="DR-56"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">CATEGORY</div>
                        <div class="col-md-3">
                            <select name="catId" id="catId" class="form-control se-select">
                                <#list categoryList as cat>
                                    <option value="${cat.id!}">${cat.name!}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-md-2 text-right">M.UNIT</div>
                        <div class="col-md-3">
                            <select name="unitId" id="unitId" class="form-control se-select">
                                <#list unitList as unit>
                                    <option value="${unit.id!}">${unit.name!}</option>
                                </#list>
                            </select>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">CATEGORY</div>
                        <div class="col-md-3">
                            <select name="maufId" id="maufId" class="form-control se-select">
                                <option value="0">--Select Manufacturer--</option>
                                <#list maufList as manufacturer>
                                    <option value="${manufacturer.id!}">${manufacturer.name!}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-md-2 text-right">M.UNIT</div>
                        <div class="col-md-3">
                            <input type="submit" class="form-control btn btn-success"
                                   value="Save Item"/>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</@layout.se_app_layout>