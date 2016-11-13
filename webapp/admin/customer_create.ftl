<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<form action="${ctx}/admin/saveCustomer.se" method="post">
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
                        <div class="col-md-2 text-right">CUSTOMER NAME</div>
                        <div class="col-md-3">
                            <input type="text" name="name" id="name" class="form-control" value="Jamal Uddin Khan"/>
                        </div>

                        <div class="col-md-2 text-right">KEY NAME</div>
                        <div class="col-md-3"><input type="text" name="keyName" id="keyName" class="form-control"
                                                     value="Jamal"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">CELL PHONE</div>
                        <div class="col-md-3"><input type="text" name="cellPhone" id="cellPhone" class="form-control"
                                                     value="01878455555"/>
                        </div>

                        <div class="col-md-2 text-right">OTHER PHONE</div>
                        <div class="col-md-3"><input type="text" name="altPhone" id="altPhone" class="form-control"
                                                     value="4258444-56"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">CUSTOMER TYPE</div>
                        <div class="col-md-3">
                            <select name="custType" id="custType" class="form-control se-select">
                                <option value="0">Irregular</option>
                                <option value="1">Regular</option>
                            </select>
                        </div>

                        <div class="col-md-2 text-right">EMAIL ADDRESS</div>
                        <div class="col-md-3"><input type="text" name="emailAddress" id="emailAddress"
                                                     class="form-control"
                                                     value="jamal@kamal.com"/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-2 text-right">NATIONAL ID NO.</div>
                        <div class="col-md-3"><input type="text" name="nid" id="nid" class="form-control"
                                                     value="445154587454545"/>
                        </div>

                        <div class="col-md-2 text-right">TAXP. ID NO. (TIN)</div>
                        <div class="col-md-3"><input type="text" name="tin" id="tin" class="form-control"
                                                     value="FA-42-58444-56"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">MAILING ADDRESS</div>
                        <div class="col-md-3"><textarea name="mailingAddress" id="mailingAddress" cols="3"
                                                        class="form-control se-textarea">42/3, Badda, Dhaka</textarea>
                        </div>

                        <div class="col-md-2 text-right">BUSINESS ADDRESS</div>
                        <div class="col-md-3"><textarea name="businessAddress" id="businessAddress" cols="3"
                                                        class="form-control se-textarea">4/3, C/A, Motijheel Dhaka</textarea>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-9"></div>
                        <div class="col-md-3"><input type="submit" class="form-control btn btn-success"
                                                     value="Save Customer"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</@layout.se_app_layout>
