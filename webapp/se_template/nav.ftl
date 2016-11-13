<nav class="navbar brb" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-reorder"></span>
        </button>
        <a class="navbar-brand" href="#"><img height="30px" width="39px"
                                              src="../resources/images/logo/se_logo.png"/></a>
    </div>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li class="active">
                <a href="${ctx}/home/home.se">
                    <span class="icon-home"></span> dashboard
                </a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                        class="icon-key"></span> Security</a>
                <ul class="dropdown-menu">
                    <li><a href="${ctx}/security/createOperation.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                        Create Operation</a></li>
                    <li><a href="${ctx}/security/createAuthority.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                        Create Authority</a></li>
                    <li><a href="${ctx}/security/createGroup.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                        Create Group</a></li>
                    <li><a href="${ctx}/security/operationList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;
                        Operation List</a></li>
                    <li><a href="${ctx}/security/loginLogList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;
                        Login Log List</a></li>
                    <li><a href="${ctx}/security/assigningOperations.se"><span class="icon-random"></span>&nbsp;&nbsp;
                        Assign Operations</a></li>
                    <li><a href="${ctx}/security/assigningAuthorities.se"><span class="icon-random"></span>&nbsp;&nbsp;
                        Assign Authorities</a></li>
                    <li><a href="${ctx}/security/assigningGroups.se"><span class="icon-random"></span>&nbsp;&nbsp;
                        Assign Groups</a></li>

                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                        class="icon-user"></span> Admin</a>
                <ul class="dropdown-menu">
                    <li><a href="${ctx}/admin/createStaff.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                        Create Staff</a></li>
                    <li><a href="${ctx}/admin/createCustomer.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                        Create Customer</a></li>
                    <li><a href="${ctx}/admin/createManufacturer.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;
                        Create Manufacturer</a></li>
                    <li><a href="${ctx}/admin/staffList.se"><span class="icon-th-list"></span>&nbsp;&nbsp; Staff
                        List</a></li>
                    <li><a href="${ctx}/admin/customerList.se"><span class="icon-th-list"></span>&nbsp;&nbsp; Customer
                        List</a></li>

                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                        class="icon-file-alt"></span> Vouchers</a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="${ctx}/accounts/createJournalVoucher.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;Journal
                            Vr Create</a>
                    </li>
                    <li>
                        <a href="${ctx}/accounts/createCrVoucher.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;Credit
                            Vr Create</a>
                    </li>
                    <li><a href="${ctx}/accounts/drCrVrList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Party VR
                        List</a></li>
                    <li><a href="${ctx}/accounts/voucherListAll.se"><span class="icon-th-list"></span>&nbsp;&nbsp;All
                        Voucher List</a></li>
                    <li><a href="${ctx}/accounts/journalVrList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Journal
                        Voucher List</a></li>
                    <li><a href="${ctx}/accounts/salesVrList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Sales
                        Voucher List</a></li>
                    <li><a href="${ctx}/accounts/drCrVrList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Party
                        Voucher List</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="icon-pencil"></span>
                    Ledgers</a>
                <ul class="dropdown-menu">
                    <li><a href="${ctx}/shop/salesLedgerList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Sales
                        Ledger List</a></li>
                    <li><a href="${ctx}/shop/stockLedgerList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Stock
                        Ledger List</a></li>
                    <li><a href="${ctx}/shop/createStockLedger.se?source=Purchase"><span
                            class="icon-plus-sign-alt"></span>&nbsp;&nbsp;Purchase Ledger</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="icon-cogs"></span>
                    Config</a>
                <ul class="dropdown-menu">
                    <li><a href="${ctx}/shop/createItem.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;Create
                        Item</a></li>
                    <li><a href="${ctx}/shop/createStore.se"><span class="icon-plus-sign-alt"></span>&nbsp;&nbsp;Create
                        Store</a></li>
                    <li><a href="${ctx}/shop/itemList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Item List</a>
                    </li>
                    <li><a href="${ctx}/shop/mUnitList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Unit List</a>
                    </li>

                </ul>
            </li>
            <li><a href="${ctx}/shop/createSalesLedger.se"><span class="icon-plus"></span> Order</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                        class="icon-file-alt"></span> Others</a>
                <ul class="dropdown-menu">

                    <li><a href="${ctx}/accounts/profitLossLedgerList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;PL
                        Ledger List</a></li>
                    <li><a href="${ctx}/shop/itemList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Item List</a>
                    </li>
                    <li><a href="${ctx}/shop/mUnitList.se"><span class="icon-th-list"></span>&nbsp;&nbsp;Unit List</a>
                    </li>

                    <li>
                        <a href="#">Email templates<i class="icon-angle-right pull-right"></i></a>
                        <ul class="dropdown-submenu">
                            <li><a href="email_sample_1.html">Sample 1</a></li>
                            <li><a href="email_sample_2.html">Sample 2</a></li>
                            <li><a href="email_sample_3.html">Sample 3</a></li>
                            <li><a href="email_sample_4.html">Sample 4</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Error pages<i class="icon-angle-right pull-right"></i></a>
                        <ul class="dropdown-submenu">
                            <li><a href="sample_error_403.html">403 Forbidden</a></li>
                            <li><a href="sample_error_404.html">404 Not Found</a></li>
                            <li><a href="sample_error_500.html">500 Internal Server Error</a></li>
                            <li><a href="sample_error_503.html">503 Service Unavailable</a></li>
                            <li><a href="sample_error_504.html">504 Gateway Timeout</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-right" role="search" action="${ctx}/shop/searchSalesLedger.se" method="GET">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Order search 2" name="salesLedgerSearchText"
                           id="salesLedgerSearchText" style="color: #ffffff"/>
                </div>
        </form>
    </div>
</nav>