<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">

<div class="row">
    <form action="${ctx}/shop/saveStore.se" method="post">
        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Sopf;&topf;&oopf;&ropf;&eopf; &Copf;&ropf;&eopf;&aopf;&topf;&eopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-2 text-right">STORE NAME.</div>
                        <div class="col-md-3">
                            <input type="text" name="name" class="form-control"
                                   value="Store 2"/>
                        </div>

                        <div class="col-md-2 text-right">ADDRESS</div>
                        <div class="col-md-3">
                            <input type="text" name="address" class="form-control"
                                   value="78, Mugda, Dahaka"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">STARTED FROM</div>
                        <div class="col-md-3">
                            <div class="input-group">
                                <div class="input-group-addon"><span class="icon-calendar-empty"></span></div>
                                <input type="text" name="startedDate" id="startedDate" class="datepicker form-control" value=""/>
                            </div>
                        </div>

                        <div class="col-md-2 text-right">CONTACT NO.</div>
                        <div class="col-md-3">
                            <input type="text" name="contactNo" id="contactNo" class="form-control"
                                   value="01758474444"/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-10"></div>
                        <div class="col-md-2"><input type="submit" class="form-control btn btn-success"
                                                     value="Save Store"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form>
</div>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Sopf;&topf;&oopf;&ropf;&eopf; &Lopf;&iopf;&sopf;&topf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>name</th>
                        <th>Started From</th>
                        <th>Address</th>
                        <th>Contact No</th>
                    </tr>
                    </thead>
                    <tbody>

                        <#list storeList as store>
                        <tr>
                            <td>${store.id!}</td>
                            <td>${store.name!}</td>
                            <td>${store.startedFrom!}</td>
                            <td>${store.address!}</td>
                            <td>${store.contactNo!}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</@layout.se_app_layout>