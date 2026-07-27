package infinity.trader.mixin;

import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Impede que o contador de usos de uma oferta de comércio (MerchantOffer)
 * seja incrementado. Como o "cooldown"/bloqueio do villager depende desse
 * contador atingir o limite (maxUses), cancelar o incremento faz com que
 * a oferta nunca fique "sem estoque" e o jogador possa negociar
 * infinitamente com o mesmo villager.
 */
@Mixin(MerchantOffer.class)
public class MerchantOfferMixin {

    @Inject(method = "increaseUses", at = @At("HEAD"), cancellable = true)
    private void tradeNow$preventUsesIncrease(CallbackInfo ci) {
        ci.cancel();
    }
}
