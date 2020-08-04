package center.wxp.dataway.controller;

import net.hasor.dataway.config.MappingToUrl;
import net.hasor.dataway.web.BasicController;
import net.hasor.web.annotation.Get;
import net.hasor.web.annotation.MappingTo;
import net.hasor.web.annotation.PathParameter;
import net.hasor.web.objects.JsonRenderEngine;
import net.hasor.web.render.RenderType;

@MappingTo("user/info/${userID}")
@RenderType(value = "json", engineType = JsonRenderEngine.class)
public class HelloAction {
    @Get
    public void execute(@PathParameter("userID") long userID) {
        System.out.println(userID);
    }
}
