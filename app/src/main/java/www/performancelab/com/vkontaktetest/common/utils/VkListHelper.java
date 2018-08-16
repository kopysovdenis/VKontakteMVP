package www.performancelab.com.vkontaktetest.common.utils;

import java.util.ArrayList;
import java.util.List;

import www.performancelab.com.vkontaktetest.model.Owner;
import www.performancelab.com.vkontaktetest.model.WallItem;
import www.performancelab.com.vkontaktetest.rest.model.response.ItemWithSendersResponse;

public class VkListHelper {

    public static List<WallItem> getWallList(ItemWithSendersResponse<WallItem> response){
        List<WallItem> wallItems = response.items;

        for (WallItem wallItem: wallItems){
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            wallItem.setAttachmentsString(Utils.convertAttachmentToFontIcons(wallItem.getAttachments()));

            if (wallItem.haveSharedRepost()){
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());

                wallItem.getSharedRepost().setAttachmentsString(Utils.convertAttachmentToFontIcons(wallItem.getSharedRepost().getAttachments()));
            }
        }
        return wallItems;
    }
}
