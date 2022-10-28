package com.sorabh.grabfood.databinding;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class OderHistotoyCardviewBindingImpl extends OderHistotoyCardviewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.order_history_oder_date, 3);
        sViewsWithIds.put(R.id.order_history_recyclerView, 4);
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public OderHistotoyCardviewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private OderHistotoyCardviewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            );
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.orderHistoryOderPrice.setTag(null);
        this.orderHistoryRestaurantName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.dataX == variableId) {
            setDataX((com.sorabh.grabfood.domain.model.oder_history_response.Bill) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDataX(@Nullable com.sorabh.grabfood.domain.model.oder_history_response.Bill DataX) {
        this.mDataX = DataX;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.dataX);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.sorabh.grabfood.domain.model.oder_history_response.Bill dataX = mDataX;
        java.lang.String dataXRestaurantName = null;
        java.lang.String dataXTotalCost = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (dataX != null) {
                    // read dataX.restaurant_name
                    dataXRestaurantName = dataX.getRestaurant_name();
                    // read dataX.total_cost
                    dataXTotalCost = dataX.getTotal_cost();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.sorabh.grabfood.util.binding_adapter.BindingAdapterKt.price(this.orderHistoryOderPrice, dataXTotalCost);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.orderHistoryRestaurantName, dataXRestaurantName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): dataX
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}