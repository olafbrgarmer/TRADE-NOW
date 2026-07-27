package infinity.trader.mixin;

import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MerchantOffer.class)
public class MerchantOfferMixin {

    @Inject(method = "increaseUses", at = @At("HEAD"), cancellable = true)
    private void tradeNow$preventUsesIncrease(CallbackInfo ci) {
        ci.cancel();
    }
}
