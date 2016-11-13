<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<form action="${ctx}/admin/saveManufacturer.se" method="POST">
<#--<input type="hidden" name="storeId" value="1"/>-->

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header" >
                    &Copf;&uopf;&sopf;&topf;&oopf;&mopf;&eopf;&ropf; &Copf;&ropf;&eopf;&aopf;&topf;&eopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-2 text-right">MANUFACTURER NAME</div>
                        <div class="col-md-3">
                            <input type="text" name="name" id="name" class="form-control" value="Pran RFL group"/>
                        </div>

                        <div class="col-md-2 text-right">HOT LINE</div>
                        <div class="col-md-3"><input type="text" name="hotLine" id="hotLine" class="form-control"
                                                     value="01745844444"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">CELL PHONE</div>
                        <div class="col-md-3"><input type="text" name="cellPhone" id="cellPhone" class="form-control"
                                                     value="01878455555"/>
                        </div>

                        <div class="col-md-2 text-right">EMAIL</div>
                        <div class="col-md-3"><input type="text" name="email" id="email" class="form-control"
                                                     value="pran@pran-rfl.com"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">OFFICE ADDRESS</div>
                        <div class="col-md-3">
                            <input type="text" name="officeAddress" id="officeAddress"
                                            class="form-control"
                                            value="52, Motijheel"/>
                        </div>

                        <div class="col-md-2 text-right">WAREHOUSE ADDRESS</div>
                        <div class="col-md-3">
                            <input type="text" name="warehouseAddress" id="warehouseAddress"
                                                     class="form-control"
                                                     value="45, Dilkusha"/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-2 text-right">FACTORY ADDRESS</div>
                        <div class="col-md-3"><input type="text" name="factoryAddress" id="factoryAddress" class="form-control"
                                                     value="45, Dhanmodi"/>
                        </div>

                        <div class="col-md-2 text-right">COMPANY CATEGORY</div>
                        <div class="col-md-3">
                            <select name="category" id="category" class="form-control se-select">
                                <option value="A">A</option>
                                <option value="A+">A+</option>
                                <option value="AA+">AA+</option>
                                <option value="B">B</option>
                                <option value="B+">B+</option>
                                <option value="C">C</option>
                                <option value="C+">C+</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-2 text-right">SINCE</div>
                        <div class="col-md-3"><input type="text" name="since" id="since" class="form-control"
                                                     value="1985"/>
                        </div>

                        <div class="col-md-2 text-right"></div>
                        <div class="col-md-3">
                            <input type="submit" class="form-control btn btn-success"
                                   value="Save Manufacturer"/>
                        </select>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>

</form>
</@layout.se_app_layout>
