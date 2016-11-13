<div class="block block-drop-shadow">
    <div class="user bg-default bg-light-rtl">
        <div class="info">
            <#--<a href="#" class="informer informer-three">
                <span>14 / 255</span>
                Messages
            </a>-->
           <#-- <a href="#" class="informer informer-four">
                <span>${user.name!}</span>
            </a>-->
            <img src="../resources/images/users/avatar.jpg" class="img-circle img-thumbnail"/>
        </div>
    </div>
    <div class="content list-group list-group-icons">
        <a href="${ctx}/home/home.se" class="list-group-item"><span class="icon-home"></span>Home</a>
        <a href="${ctx}/security/editPassword.se" class="list-group-item"><span class="icon-key"></span>Change Password</a>
        <a href="${ctx}/auth/logout.se" class="list-group-item"><span class="icon-off text-danger"></span>Logout</a>
    </div>
</div>

