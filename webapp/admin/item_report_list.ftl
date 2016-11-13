<#import "../cust_template/cust_app_layout.ftl" as layout>
<@layout.cust_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-4 se-in-msg">${msg!}</div>
</div>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <div class="block se-block <#--block-fill-white-->">
            <div class="header se-header se-header-bl">
                &Lopf;&oopf;&gopf;&iopf;&nopf; &Lopf;&oopf;&gopf; &Lopf;&iopf;&sopf;&topf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>DATE</th>
                        <th>ITEM NAME</th>
                        <th>COMMENT</th>
                        <th>SUGGESTION</th>
                        <th>VIEWED</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list reportList as log>
                        <tr>
                            <td>${log.id!}</td>
                            <td>${log.date}</td>
                            <td>${log.item.name}</td>
                            <td>${log.comment!}</td>
                            <td>${log.suggestion!}</td>
                            <#assign view = log.viewed?string("Viewed", "Not Viewed")>
                            <td>${view!}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

</@layout.cust_app_layout>