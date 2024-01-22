#import "RTNNfcSpec.h"
#import "RTNNfc.h"

@implementation RTNNfc

RCT_EXPORT_MODULE()
//todo
- (void)add:(double)a b:(double)b resolve:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject {
    NSNumber *result = [[NSNumber alloc] initWithInteger:a+b];
    resolve(result);
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeNfcSpecJSI>(params);
}

@end
