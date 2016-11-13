<#import "../../cust_template/cust_app_layout.ftl" as layout>
<@layout.cust_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>


<div class="row">
    <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block <#--block-fill-white-->">
            <div class="header se-header">
               Item Details
            </div>
            <div class="content controls">
                <table class="table" width="100%">
                    <tbody>
                    <tr>
                    <tr>
                        <td class="se-dt-left">ITEM NAME</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${item.name!}</td>

                        <td class="se-dt-left">ITEM CODE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${item.itemCode!}</td>

                    </tr>
                    <tr>
                        <td class="se-dt-left">PRICE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${item.labeledPrice!}</td>

                        <td class="se-dt-left">CURRENT STOCK</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${item.stock!} ${item.unit.name!}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


    <#assign manufacturer = item.manufacturer>
    <#if manufacturer??>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block">
                <div class="header se-header  se-header-bl">
                    Manufacturer Details
                </div>
                <div class="content controls">
                    <table class="table" width="100%">
                        <tbody>
                        <tr>
                        <tr>
                            <td class="se-dt-left">MANUFACTURER NAME</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right" colspan="4">${manufacturer.name!}</td>
                        </tr>
                        <tr>
                            <td class="se-dt-left">HOT LINE</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${manufacturer.hotLine!}</td>

                            <td class="se-dt-left">EMAIL</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${manufacturer.email!}</td>
                        </tr>
                        <tr>
                            <td class="se-dt-left">OFFICE ADDRESS</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${manufacturer.officeAddress!}</td>

                            <td class="se-dt-left">WAREHOUSE ADDRESS</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${manufacturer.warehouseAddress!}</td>
                        </tr>
                        <tr>
                            <td class="se-dt-left">SINCE</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${manufacturer.since!}</td>

                            <td class="se-dt-left">CATEGORY</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${manufacturer.category!}</td>
                        </tr>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
    </#if>

<div class="row">
    <form action="${ctx}/admin/saveItemReport.se" method="post">
        <input type="hidden" name="itemId" value="${item.id}"/>

        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block">
                <div class="header se-header  se-header-bl">
                    Report / Suggestion on Item
                </div>
                <div class="content controls">

                    <div class="form-row">
                        <div class="col-md-2 text-right">COMMENT</div>
                        <div class="col-md-3">
                            <textarea name="comment" id="comment" cols="4" class="form-control se-textarea"></textarea>
                        </div>

                        <div class="col-md-2 text-right">SUGGESTION</div>
                        <div class="col-md-3">
                            <textarea name="suggestion" id="suggestion" cols="4"
                                      class="form-control se-textarea"></textarea>
                        </div>
                    </div>
                    <div class="form-row">

                        <div class="col-md-7 text-right"></div>
                        <div class="col-md-3">
                            <input type="submit" class="form-control btn btn-success"
                                   value="Save"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </form>
</div>
</@layout.cust_app_layout>