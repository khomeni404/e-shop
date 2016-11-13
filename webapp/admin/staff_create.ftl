<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<form action="${ctx}/admin/saveStaff.se" method="post">
<#--<input type="hidden" name="storeId" value="1"/>-->

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#-- block-fill-white -->">
                <div class="header se-header">
                    &Sopf;&topf;&aopf;&fopf;&fopf; &Copf;&ropf;&eopf;&aopf;&topf;&eopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-2 text-right">STAFF NAME</div>
                        <div class="col-md-3">
                            <input type="text" name="name" id="name" class="form-control" value="Jamal Uddin Khan"/>
                        </div>

                        <div class="col-md-2 text-right">STAFF TYPE</div>
                        <div class="col-md-3">
                            <select name="staffType" id="staffType" class="form-control se-select">
                                <option value="1">Salesman</option>
                                <option value="0">Proprietor</option>
                            </select>
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
                        <div class="col-md-2 text-right">FATHER NAME</div>
                        <div class="col-md-3"><input type="text" name="fatherName" id="fatherName" class="form-control"
                                                     value="Kamal Uddin"/>
                        </div>
                        <div class="col-md-2 text-right">REFERENCE NAME</div>
                        <div class="col-md-3"><input type="text" name="referenceName" id="referenceName" class="form-control"
                                                     value="Kamal Uddin"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">EMAIL ADDRESS</div>
                        <div class="col-md-3"><input type="text" name="emailAddress" id="emailAddress"
                                                     class="form-control"
                                                     value="jamal@kamal.com"/>
                        </div>
                        <div class="col-md-2 text-right">ADDRESS</div>
                        <div class="col-md-3"><textarea name="mailingAddress" id="mailingAddress" cols="3"
                                                        class="form-control se-textarea">42/3, Badda, Dhaka</textarea>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-2 text-right">USERNAME</div>
                        <div class="col-md-3"><input type="text" name="username" id="username" class="form-control"
                                                     value="kamal"/>
                        </div>
                        <div class="col-md-2 text-right">PASSWORD</div>
                        <div class="col-md-3"><input type="password" name="password" id="password" class="form-control"
                                                     value="kamal123"/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-10"></div>
                        <div class="col-md-2"><input type="submit" class="form-control btn btn-success"
                                                     value="Save Staff"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</@layout.se_app_layout>
