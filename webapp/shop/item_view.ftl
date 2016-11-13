<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>


<div class="row">
    <form action="${ctx}/shop/updateItem.se" method="post">
        <input type="hidden" name="id" value="${item.id}"/>

        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Vopf;&iopf;&eopf;&wopf; & &Eopf;&dopf;&iopf;&topf; &Iopf;&topf;&eopf;&mopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-2 text-right">ITEM NAME.</div>
                        <div class="col-md-3">
                            <input type="text" name="name" class="form-control"
                                   value="${item.name!}"/>
                        </div>

                        <div class="col-md-2 text-right">ITEM CODE</div>
                        <div class="col-md-3">
                            <input type="text" name="code" class="form-control"
                                   value="${item.itemCode!}"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">STOCK</div>
                        <div class="col-md-3">
                            <input type="text" name="stock" class="form-control"
                                   value="${item.stock!}"/>
                        </div>

                        <div class="col-md-2 text-right">LABELED PRICE</div>
                        <div class="col-md-3">
                            <input type="text" name="labeledPrice" class="form-control"
                                   value="${item.labeledPrice!}"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">UNIT</div>
                        <div class="col-md-3">
                            <input type="text" name="priceCode" class="form-control" disabled style="color: black"
                                   value="${item.unit.name!}"/>
                        </div>

                        <div class="col-md-2 text-right">PURCHASED PRICE</div>
                        <div class="col-md-3">
                            <input type="text" name="purchasedPrice" class="form-control"
                                   value="${item.purchasedPrice!}"/>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="col-md-10"></div>
                        <div class="col-md-2"><input type="submit" class="form-control btn btn-success"
                                                     value="Update Item"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>


<#assign manufacturer = item.manufacturer>
<#if manufacturer??>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header  se-header-bl">
                Manufacturer
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
</@layout.se_app_layout>